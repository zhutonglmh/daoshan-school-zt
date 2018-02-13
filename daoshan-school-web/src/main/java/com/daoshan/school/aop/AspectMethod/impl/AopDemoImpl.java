package com.daoshan.school.aop.AspectMethod.impl;

import com.daoshan.school.aop.AspectMethod.AopDemo;
import org.springframework.stereotype.Service;

@Service
public class AopDemoImpl implements AopDemo {

    @Override
    public String aopDemo() {
        System.out.println("Aop******************************测试成功");
        return "aopsuccess";
    }
}
