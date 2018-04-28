package com.daoshan.bean.dsxh.entity;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@TableName("dsxh_user")
public class DsxhUser extends Model<DsxhUser>{


    /**
     * 用户名
     */
    private String name;

    /**
     * 用户密码
     */
    private String pwd;

    /**
     * 用户是否是vip
     */
    private int vip;

    /**
     * 主键
     */
    private String id;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 修改时间
     */
    private Timestamp updateTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 是否有效
     */
    private int status;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 账户余额
     */
    private Double money;
    @Override
    protected Serializable pkVal() {
        return null;
    }
}
