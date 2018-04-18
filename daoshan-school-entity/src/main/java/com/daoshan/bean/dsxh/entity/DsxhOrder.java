package com.daoshan.bean.dsxh.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("dsxh_order")
public class DsxhOrder extends Model<DsxhOrder> {
    private String id;

    private String courseId;

    private String courseName;

    private BigDecimal price;

    private String createUser;

    private Date createTime;

    private String userName;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}