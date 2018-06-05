package com.daoshan.dao.dsxh;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cohen.redis.annotation.RedisCached;
import com.daoshan.bean.dsxh.entity.DsxhCollection;
import com.daoshan.bean.dsxh.entity.DsxhCourse;
import com.daoshan.bean.dsxh.entity.DsxhUser;

import java.util.List;

public interface DsxhCollectionMapper extends BaseMapper<DsxhCollection> {

    /**
     * 取消收藏
     * @param dsxhCollection
     * @return
     */
    int deleteByUserAndCourse(DsxhCollection dsxhCollection);

    /**
     * 获取所有用户收藏课程
     * @param dsxhUser
     * @return
     */
    @RedisCached
    List<DsxhCourse> getCollectByUser(DsxhUser dsxhUser);
}
