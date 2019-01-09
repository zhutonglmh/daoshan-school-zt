package com.daoshan.service.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhCourse;

import java.util.List;

/**
 * 课程类
 *
 * Created By 张崇宝 On 2018-4-11 21:05:58
 *
 * @author 张崇宝
 *
 */
public interface DsxhCourseService {

    /**
     * 获取课程信息
     * @param dsxhCourse
     * @return
     * @throws Exception
     */
    DsxhCourse getCourseInfo(DsxhCourse dsxhCourse) throws Exception;

    /**
     * 添加课程
     * @param dsxhCourse
     * @return
     */
    DsxhCourse addCourse(DsxhCourse dsxhCourse);

    /**
     * 条件搜索
     * @param dsxhCourse
     * @return
     */
    List<DsxhCourse> courseSearch(DsxhCourse dsxhCourse);

    /**
     * 根据类别进行搜索
     * @param dsxhCourse
     * @return
     */
    List<DsxhCourse> courseSearchByType(DsxhCourse dsxhCourse);

    /**
     * 分页搜索
     * @param dsxhCourse
     * @return
     */
    List<DsxhCourse> findDataForPage(DsxhCourse dsxhCourse);

    /**
     * 删除
     * @param dsxhCourse
     * @return
     */
    int delete(DsxhCourse dsxhCourse);

}
