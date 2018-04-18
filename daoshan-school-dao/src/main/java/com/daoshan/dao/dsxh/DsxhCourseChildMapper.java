package com.daoshan.dao.dsxh;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.daoshan.bean.dsxh.entity.DsxhCourseChild;

import java.util.List;

public interface DsxhCourseChildMapper extends BaseMapper<DsxhCourseChild> {

    List<DsxhCourseChild> getChildren (DsxhCourseChild dsxhCourseChild) ;
}