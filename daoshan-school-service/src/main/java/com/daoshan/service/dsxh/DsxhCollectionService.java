package com.daoshan.service.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhCollection;

public interface DsxhCollectionService {

    /**
     * 新增
     * @param dsxhCollection
     * @return
     */
    int add(DsxhCollection dsxhCollection);

    /**
     * 判断课程是否被收藏
     */
    int checkCollect(DsxhCollection dsxhCollection);

    /**
     * 根据条件删除
     * @param dsxhCollection
     * @return
     */
    int deleteCollect(DsxhCollection dsxhCollection);
}
