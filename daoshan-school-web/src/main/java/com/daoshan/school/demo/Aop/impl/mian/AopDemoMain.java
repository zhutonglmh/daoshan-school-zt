package com.daoshan.school.demo.Aop.impl.mian;

import com.daoshan.school.demo.Aop.AopDemoInterface;
import com.daoshan.school.demo.Aop.impl.AopDemoImpl;
import com.daoshan.school.demo.Aop.target.AopTargetDemo;

/**
 * 演示aop的实现原理 (静态代理)
 */
public class AopDemoMain {

    public static void main(String[] args) {

        AopDemoInterface aop = new AopDemoImpl(new AopTargetDemo()); //使用代理类

        aop.request();
    }
}
