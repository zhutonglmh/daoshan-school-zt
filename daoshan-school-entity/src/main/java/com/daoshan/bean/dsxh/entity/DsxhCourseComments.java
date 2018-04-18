package com.daoshan.bean.dsxh.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("dsxh_course_comments")
public class DsxhCourseComments extends Model<DsxhUser> {

    private String id;

    private String courseId;

    private Integer commentLoves;

    private Integer commentHates;

    private Date createTime;

    private String createUser;

    private String createUserName;

    private String parentId;

    private String commentMessage;

    @TableField(exist = false)
    private List<DsxhCourseComments> commentsList;

    @TableField(exist = false)
    private String createTimeStr;
    @Override
    protected Serializable pkVal() {
        return null;
    }
}