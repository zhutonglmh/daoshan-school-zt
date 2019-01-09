package com.daoshan.service.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhCollection;
import com.daoshan.bean.dsxh.entity.DsxhCourse;
import com.daoshan.bean.dsxh.entity.DsxhUser;

import java.util.List;

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

    /**
     * 查询该用户下的所有收藏课程
     */
    List<DsxhCourse> getCollectByUser(DsxhUser dsxhUser);
}
