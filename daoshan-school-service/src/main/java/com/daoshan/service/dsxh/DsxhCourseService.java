package com.daoshan.service.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhCourse;

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
    DsxhCourse getCourseInfo(DsxhCourse dsxhCourse);
}
