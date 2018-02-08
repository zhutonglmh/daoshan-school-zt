package com.daoshan.bean.common;

import lombok.Data;

import java.util.Date;

/**
 * 基本信息实体类
 */
public class BaseInfo {

    /**
     * 主键
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Data updateTime;

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
}
