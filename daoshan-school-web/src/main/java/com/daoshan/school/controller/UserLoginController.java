package com.daoshan.school.controller;

import com.daoshan.bean.UserLogin;
import com.daoshan.dao.UserLoginMapper;
import com.daoshan.service.dsxh.DsxhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
@RestController
@RequestMapping("demo")
public class UserLoginController {


    @Resource
    private UserLoginMapper userLoginMapper;

    @Autowired
    private DsxhUserService dsxhUserService;

    @PostMapping("/userLogin")
    @ResponseBody
    public String Demo(){

        Map<String,Object> map = new HashMap<String,Object>();

        List<UserLogin> list = userLoginMapper.selectUserMse(map);

        UserLogin userLogin = new UserLogin();
        userLogin.setId(1);
        userLoginMapper.selectOne(userLogin);
        userLoginMapper.selectById(userLogin.getId());
        System.out.println("哈哈哈哈哈  暂时就先这样吧");
        return JSON.toJSONString(userLoginMapper.selectById(userLogin.getId()));
    }
    @PostMapping("set/session")
    @ResponseBody
    public String setSession(HttpSession session){
        session.setAttribute("name","zhutong");
        return "success";
    }

    @PostMapping("get/session")
    @ResponseBody
    public String getSession(HttpSession session){

        return dsxhUserService.sessionDemo();
    }

    /*-------------------------------------------------------------------------------------------------------*/
            //以上代码仅供测试框架使用      正式环境可以删除
    /*--------------------------------------------------------------------------------------------------------*/


}
