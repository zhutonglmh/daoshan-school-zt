package com.daoshan.service.dsxh.impl;

import com.daoshan.service.dsxh.DsxhUserService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service("dsxhUserService")
public class DsxhUserServiceImpl implements DsxhUserService{

    @Override
    public String sessionDemo() {
        //获取到当前线程绑定的请求对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //已经拿到session,就可以拿到session中保存的用户信息了。
        System.out.println(request.getSession().getAttribute("name"));
        String name = request.getSession().getAttribute("name").toString();
        return name;
    }
}
