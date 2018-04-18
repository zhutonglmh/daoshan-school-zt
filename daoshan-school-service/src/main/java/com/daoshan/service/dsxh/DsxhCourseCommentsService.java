package com.daoshan.service.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhCourseComments;

import java.util.List;

public interface DsxhCourseCommentsService {

    /**
     * 获取课程评论
     * @param dsxhCourseComments
     * @return
     */
    List<DsxhCourseComments> getCourseComments(DsxhCourseComments dsxhCourseComments);

    /**
     * 新增评论
     */
    int addDsxhCourseComments(DsxhCourseComments dsxhCourseComments);

    /**
     * 修改
     * @param dsxhCourseComments
     * @return
     */
    int updateComments(DsxhCourseComments dsxhCourseComments);

    /**
     * 获取某一评论的所有子评论
     * @param dsxhCourseComments
     * @return
     */
    List<DsxhCourseComments> getCourseCommentsByParentId(DsxhCourseComments dsxhCourseComments);

}
