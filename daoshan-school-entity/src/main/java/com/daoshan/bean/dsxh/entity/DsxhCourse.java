package com.daoshan.bean.dsxh.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("dsxh_course")
public class DsxhCourse extends Model<DsxhUser> {

    private String id;

    private String courseName;

    private String bigTypeId;

    private String bigTypeName;

    private String typeId;

    private String typeName;

    private String childTypeId;

    private String childTypeName;

    private Double coursePrice;

    private String pictureAddress;

    private Date createTime;

    private String createUser;

    private Short deleteFlag;

    private Integer praiseNumber;

    private String teacherName;

    @TableField(exist = false)
    private String courseMessage;

    @TableField(exist = false)
    private DsxhCourseDetail dsxhCourseDetail;

    @TableField(exist = false)
    private List<DsxhCourseChild> dsxhCourseChildren;

    @TableField(exist = false)
    private List<DsxhCourseComments> commentsList;

    @TableField(exist = false)
    private String vedioAddress;

    @TableField(exist = false)
    private String queryString;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}