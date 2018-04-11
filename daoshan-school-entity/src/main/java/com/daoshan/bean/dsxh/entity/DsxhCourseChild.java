package com.daoshan.bean.dsxh.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("dsxh_course_child")
public class DsxhCourseChild extends Model<DsxhUser> {
    private String id;

    private String courseId;

    private Integer number;

    private String address;

    private String name;

    private String courseName;

    private Date createTime;

    private String createUser;

    private Short deleteFlag;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}