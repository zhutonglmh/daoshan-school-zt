package com.daoshan.bean.dsxh.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("dsxh_order")
public class DsxhOrder extends Model<DsxhOrder> {

    /**
     * 主键
     */
    private String id;

    /**
     * 课程id
     */
    private String courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 单号
     */
    private String billNo;

    /**
     * 实付金额
     */
    private BigDecimal priceAmt;

    /**
     * 订单状态
     */
    private Integer status;   //0 未支付   1  已支付  2 审核退款  4 已退款
    /**
     * 课程单价
     */
    private BigDecimal price;


    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 字符串时间
     */
    @TableField(exist = false)
    private String timeStr;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}