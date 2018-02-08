package com.daoshan.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 实体bean 对应数据库中的user_zt表
 * 
 * @author 朱同  2017/12/7
 *
 */
@Data
@TableName("user_login")
public class UserLogin implements Serializable {


    /*-------------------------------------------------------------------------------------------------------*/
    //本代码仅供测试框架使用      正式环境可以删除
    /*--------------------------------------------------------------------------------------------------------*/

    /**
     * 用户id，对应表中字段id
     */
    private Integer id;

    /**
     * 用户姓名，对应表中字段username
     */
    private String username;

    /**
     * 用户密码，对应表中字段userpassword
     */
    private String userpassword;

    /**
     * 用户是否是管理员，对应表中字段isadm ('0'：非管理员； '1'：管理员)
     */
    private String isadm;

    @TableField(exist = false)
    private String demo1;
    /**
     * 还账号是否使用，对应表中字段issys ('0'：不再使用； '1'：正在使用)
     */
    private String issys;

}