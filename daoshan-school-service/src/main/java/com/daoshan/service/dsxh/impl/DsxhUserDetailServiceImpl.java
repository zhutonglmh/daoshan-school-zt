package com.daoshan.service.dsxh.impl;

import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.bean.dsxh.entity.DsxhUserDetail;
import com.daoshan.dao.dsxh.DsxhUserDetailMapper;
import com.daoshan.school.utils.common.AirUtils;
import com.daoshan.school.utils.uuid.UUIDUtils;
import com.daoshan.service.dsxh.DsxhUserDetailService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class DsxhUserDetailServiceImpl implements DsxhUserDetailService{

    @Resource
    private DsxhUserDetailMapper dsxhUserDetailMapper;

    @Autowired
    private DsxhUserService dsxhUserService;

    @Override
    public DsxhUser getDsxhUserById(DsxhUser dsxhUser) {

        DsxhUser dsxhUser1 = dsxhUserService.queryUser(dsxhUser);

        DsxhUserDetail dsxhUserDetail = new DsxhUserDetail();
        dsxhUserDetail.setUserId(dsxhUser.getId());
        DsxhUserDetail dsxhUserDetail2 = dsxhUserDetailMapper.selectOne(dsxhUserDetail);
        dsxhUser1.setDsxhUserDetail(dsxhUserDetail2);
        return dsxhUser1;
    }

    /**
     * 新增
     * @param dsxhUserDetail
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public String addDsxhUserDetail(DsxhUserDetail dsxhUserDetail) throws Exception {

        DsxhUser dsxhUser = dsxhUserService.getUserInfo();
        if(!AirUtils.hv(dsxhUser)) return "当前无登录用户";
        dsxhUserDetail.setUserId(dsxhUser.getId());
        String uuid = UUIDUtils.getUUID();
        dsxhUserDetail.setId(uuid);
        dsxhUser.setUserName(dsxhUserDetail.getUserName());
        int result1 = dsxhUserService.updateUserInfo(dsxhUser);
        dsxhUserDetailMapper.deleteByUser(dsxhUserDetail);
        if(!AirUtils.hv(dsxhUserDetail.getHeadImageAddress())){
            dsxhUserDetail.setHeadImageAddress("head");
        }
        int result = dsxhUserDetailMapper.insert(dsxhUserDetail);
        return result > 0 ? "success" : "保存失败";
    }

    /**
     * 删除
     * @param dsxhUserDetail
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public String delDsxhUserDetail(DsxhUserDetail dsxhUserDetail) throws Exception {
        return null;
    }

    /**
     * 查看
     * @return
     * @throws Exception
     */
    @Override
    public DsxhUser getUserInfo() throws Exception {

        DsxhUser dsxhUser = dsxhUserService.getUserInfo();
        if(!AirUtils.hv(dsxhUser)){
            return null;
        }
        DsxhUserDetail dsxhUserDetail = new DsxhUserDetail();
        dsxhUserDetail.setUserId(dsxhUser.getId());
        dsxhUserDetail = dsxhUserDetailMapper.getDsxhUserDetailByUser(dsxhUserDetail);
        dsxhUser.setDsxhUserDetail(dsxhUserDetail);
        return dsxhUser;
    }
}
