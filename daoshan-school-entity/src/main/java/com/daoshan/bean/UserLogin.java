package com.daoshan.bean;

/**
 * 
 * 实体bean 对应数据库中的user_zt表
 * 
 * @author 朱同  2017/12/7
 *
 */
public class UserLogin {
    
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

    /**
     * 还账号是否使用，对应表中字段issys ('0'：不再使用； '1'：正在使用)
     */
    private String issys;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getIsadm() {
        return isadm;
    }

    public void setIsadm(String isadm) {
        this.isadm = isadm == null ? null : isadm.trim();
    }

    public String getIssys() {
        return issys;
    }

    public void setIssys(String issys) {
        this.issys = issys == null ? null : issys.trim();
    }
    /**
     * 获取当前类的String 展示
     */
    public String toString() {
        return this.toString();
    }
}