package com.daoshan.service.dsxh.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.daoshan.bean.dsxh.entity.DsxhCollection;
import com.daoshan.bean.dsxh.entity.DsxhCourse;
import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.dao.dsxh.DsxhCollectionMapper;
import com.daoshan.school.utils.uuid.UUIDUtils;
import com.daoshan.service.dsxh.DsxhCollectionService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DsxhCollectionServiceImpl implements DsxhCollectionService{

    @Resource
    private DsxhCollectionMapper dsxhCollectionMapper;

    @Autowired
    private DsxhUserService dsxhUserService;
    @Override
    @Transactional
    public int add(DsxhCollection dsxhCollection) {

        DsxhUser dsxhUser = dsxhUserService.getUserInfo();
        dsxhCollection.setCreateUser(dsxhUser.getId());
        dsxhCollection.setUserName(dsxhUser.getUserName());
        dsxhCollection.setCreateTime(new Date());
        dsxhCollection.setId(UUIDUtils.getUUID());
        return dsxhCollectionMapper.insert(dsxhCollection);
    }

    @Override

    public int checkCollect(DsxhCollection dsxhCollection) {

        dsxhCollection.setCreateUser(dsxhUserService.getUserInfo().getId());
        Wrapper<DsxhCollection> wrapper = new EntityWrapper<>(dsxhCollection);
        List<DsxhCollection> list = dsxhCollectionMapper.selectList(wrapper);
        if(CollectionUtils.isEmpty(list)){
            return 0;
        }
        return 1;
    }

    @Override
    @Transactional
    public int deleteCollect(DsxhCollection dsxhCollection) {
        dsxhCollection.setCreateUser(dsxhUserService.getUserInfo().getId());
        return dsxhCollectionMapper.deleteByUserAndCourse(dsxhCollection);
    }

    @Override
    public List<DsxhCourse> getCollectByUser(DsxhUser dsxhUser) {
        return dsxhCollectionMapper.getCollectByUser(dsxhUser);
    }
}
