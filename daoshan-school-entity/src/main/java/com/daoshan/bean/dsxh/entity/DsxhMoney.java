package com.daoshan.bean.dsxh.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@TableName("dsxh_money")
public class DsxhMoney extends Model<DsxhMoney> {

    private String id;

    private Integer type;

    private String cause;

    private Double money;

    private String createUser;

    private Date createTime;

    /**
     * 单号
     */
    private String billNo;
    @TableField(exist = false)
    private int start;

    @TableField(exist = false)
    private int limit;

    @TableField(exist = false)
    private String time;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
