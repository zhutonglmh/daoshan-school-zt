package com.daoshan.dao.dsxh;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.daoshan.bean.dsxh.entity.DsxhCourseComments;

import java.util.List;

public interface DsxhCourseCommentsMapper extends BaseMapper<DsxhCourseComments> {

    public List<DsxhCourseComments> selectList2 (DsxhCourseComments dsxhCourseComments);
}