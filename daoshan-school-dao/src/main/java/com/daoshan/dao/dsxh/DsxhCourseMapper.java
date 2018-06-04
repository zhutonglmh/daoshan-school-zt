package com.daoshan.dao.dsxh;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.daoshan.bean.dsxh.entity.DsxhCourse;

import java.util.List;

public interface DsxhCourseMapper extends BaseMapper<DsxhCourse> {

    List<DsxhCourse> courseSearch (DsxhCourse dsxhCourse);

    List<DsxhCourse> courseSearchByType(DsxhCourse dsxhCourse);
}