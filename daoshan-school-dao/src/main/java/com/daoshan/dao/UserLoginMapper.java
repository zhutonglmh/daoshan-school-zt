package com.daoshan.dao;


import com.daoshan.bean.UserLogin;

import java.util.List;
import java.util.Map;

/**
 * 
 * 用户信息表处理方法 dao 层接口
 * 
 * @author 朱同   2017/12/7
 * 
 */
public interface UserLoginMapper {
    
    /**
     * 
     * @param map
     *      (userName: 用户名； password: 密码；)
     * @return
     *      (result:验证结果;)
     */
    List<UserLogin> selectUserMse(Map<String, Object> map);
}