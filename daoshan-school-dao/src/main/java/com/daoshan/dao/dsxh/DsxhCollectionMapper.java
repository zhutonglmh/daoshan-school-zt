package com.daoshan.dao.dsxh;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.daoshan.bean.dsxh.entity.DsxhCollection;

public interface DsxhCollectionMapper extends BaseMapper<DsxhCollection> {

    /**
     * 取消收藏
     * @param dsxhCollection
     * @return
     */
    int deleteByUserAndCourse(DsxhCollection dsxhCollection);
}
