package com.daoshan.bean.dsxh.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("dsxh_collection")
public class DsxhCollection {

    private String id;

    private String courseId;

    private String courseName;

    private String createUser;

    private Date createTime;

    private String userName;

}
