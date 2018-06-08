package com.daoshan.service.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhCourse;

import java.util.List;

/**
 * 课程类
 *
 * Created By zhuTong On 2018-4-11 21:05:58
 *
 * @author zhuTong
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

}