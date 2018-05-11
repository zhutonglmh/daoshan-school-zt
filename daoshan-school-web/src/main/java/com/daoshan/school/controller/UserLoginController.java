package com.daoshan.school.controller;

import com.daoshan.bean.UserLogin;
import com.daoshan.dao.UserLoginMapper;
import com.daoshan.service.dsxh.DsxhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
@Controller
@RequestMapping("demo")
public class UserLoginController {


    @Resource
    private UserLoginMapper userLoginMapper;

    @Autowired
    private DsxhUserService dsxhUserService;
    
    /*-------------------------------------------------------------------------------------------------------*/
            //以上代码仅供测试框架使用      正式环境可以删除
    /*--------------------------------------------------------------------------------------------------------*/

    @RequestMapping(path = {"/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String index(){
        return "Demo";
    }

    @RequestMapping(path = {"/index2"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String index2(){
        return "Demo";
    }
}
