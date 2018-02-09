package com.daoshan.service.dsxh.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.dao.dsxh.DsxhUserMapper;
import com.daoshan.school.utils.constans.ConStants;
import com.daoshan.school.utils.md5.Md5;
import com.daoshan.school.utils.uuid.UUIDUtils;
import com.daoshan.service.dsxh.DsxhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service("dsxhUserService")
public class DsxhUserServiceImpl implements DsxhUserService{


    @Resource
    private DsxhUserMapper dsxhUserMapper;

    /**
     * 测试功能使用
     * @return
     */
    @Override
    public String sessionDemo() {
        //获取到当前线程绑定的请求对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //已经拿到session,就可以拿到session中保存的用户信息了。
        String name = request.getSession().getAttribute("id").toString();
        return name;
    }


    /*-------------------------------------------------------------------------------------------------------*/
    //以上代码仅供测试框架使用      正式环境可以删除
    /*--------------------------------------------------------------------------------------------------------*/

    /**
     * 新增
     *
     * @param dsxhUser
     * @return
     */
    @Override
    public String insertUser(DsxhUser dsxhUser) {

        //MD5加密
        String password = dsxhUser.getPwd();
        dsxhUser.setPwd(Md5.getMd5ByParams(password));
        //获取uuid
        String userId = UUIDUtils.getUUID();
        dsxhUser.setId(userId);
        //获取当前用户
        //dsxhUser.setCreateUser(sessionDemo());
        //获取当前时间
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        dsxhUser.setCreateTime(timestamp);
        int insertResult = dsxhUserMapper.insert(dsxhUser);
        String result = insertResult > 0 ? ConStants.DSXH_SUCCESS : ConStants.DSXH_FAILUER;
        return result;
    }

    /**
     * 修改
     *
     * @param dsxhUser
     * @return
     */
    @Override
    public String updateUser(DsxhUser dsxhUser) {

        if(null != dsxhUser.getPwd()){
            //MD5加密
            String password = dsxhUser.getPwd();
            dsxhUser.setPwd(Md5.getMd5ByParams(password));
        }
        //获取当前用户
        //dsxhUser.setCreateUser(sessionDemo());
        //获取当前时间
        Date date = new Date();
        System.out.println(date);
        Timestamp timestamp = new Timestamp(date.getTime());
        dsxhUser.setCreateTime(timestamp);

        int updateResult = dsxhUserMapper.updateById(dsxhUser);


        String result = updateResult > 0 ? ConStants.DSXH_SUCCESS : ConStants.DSXH_FAILUER;

        return result;
    }

    /**
     * 删除
     *
     * @param dsxhUser
     * @return
     */
    @Override
    public String deleteUser(DsxhUser dsxhUser) {

        int deleteResult = dsxhUserMapper.deleteById(dsxhUser);

        String result = deleteResult > 0 ? ConStants.DSXH_SUCCESS : ConStants.DSXH_FAILUER;

        return result;
    }

    /**
     * 精确查询
     *
     * @param dsxhUser
     * @return
     */
    @Override
    public DsxhUser queryUser(DsxhUser dsxhUser) {

        dsxhUser = dsxhUserMapper.selectById(dsxhUser);

        return dsxhUser;
    }

    /**
     * 条件查询
     *
     * @param dsxhUser
     * @return
     */
    @Override
    public List<DsxhUser> queryUserList(DsxhUser dsxhUser) {

        return null;
    }

    /**
     * 分页查询
     * @param page
     * @param dsxhUser
     * @return
     */
    public Page<DsxhUser> findDataForPage(Page<DsxhUser> page,DsxhUser dsxhUser){

        List<DsxhUser> list = dsxhUserMapper.selectByZt(page,dsxhUser);
        page.setRecords(list);
        return page;
    }


}
