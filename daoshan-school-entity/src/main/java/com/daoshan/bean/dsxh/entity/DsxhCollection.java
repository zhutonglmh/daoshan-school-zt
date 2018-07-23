package com.daoshan.bean.dsxh.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("dsxh_collection")
public class DsxhCollection extends Model<DsxhCollection> {

    private String id;

    private String courseId;

    private String courseName;

    private String createUser;

    private Date createTime;

    private String userName;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
