package com.daoshan.bean.dsxh.entity;


import com.baomidou.mybatisplus.annotations.TableName;
import com.daoshan.bean.common.BaseInfo;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName("dsxh_user")
public class DsxhUser extends BaseInfo implements Serializable{


    /**
     * 用户名
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户是否是vip
     */
    private int vip;

}
