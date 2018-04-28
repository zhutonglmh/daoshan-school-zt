package com.daoshan.bean.dsxh.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("dsxh_user_detail")
public class DsxhUserDetail extends Model<DsxhUserDetail> {

    private String id;

    private String userId;

    private String userSex;

    private String headImageAddress;

    private String userReallyName;

    private String userMessage;

    private String userEmail;

    private String userIphone;

    private String userQqNumber;

    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return null;
    }
}