package com.daoshan.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.daoshan.bean.UserLogin;

import java.util.List;
import java.util.Map;

/**
 * 
 * 用户信息表处理方法 dao 层接口
 * 
 * @author 张崇宝   2018/12/7
 * 
 */
public interface UserLoginMapper extends BaseMapper<UserLogin> {

    /*-------------------------------------------------------------------------------------------------------*/
    //本代码仅供测试框架使用      正式环境可以删除
    /*--------------------------------------------------------------------------------------------------------*/

    /**
     * 
     * @param map
     *      (userName: 用户名； password: 密码；)
     * @return
     *      (result:验证结果;)
     */
    List<UserLogin> selectUserMse(Map<String, Object> map);
}