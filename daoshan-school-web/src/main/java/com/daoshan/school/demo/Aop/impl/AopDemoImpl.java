package com.daoshan.school.demo.Aop.impl;

import com.daoshan.school.demo.Aop.AopDemoInterface;
import com.daoshan.school.demo.Aop.target.AopTargetDemo;

/**
 * 演示 spring-aop  代理模式（静态代理）
 *
 * 总接口  包含了代理对象的方法 和 目标对象的方法
 */
public class AopDemoImpl implements AopDemoInterface{

    /**
     * 引入目标对象
     */
    private AopTargetDemo aopTargetDemo;

    public AopDemoImpl(AopTargetDemo aopTargetDemo) {
        this.aopTargetDemo = aopTargetDemo;
    }

    /**
     * 必须有request() 方法
     */
    @Override
    public void request() {

        System.out.println("我就等于before");
        //不会改变目标对象的方法即不会改变真正的执行方法  只是在执行目标对象的前后添加自己的逻辑
       try {
           aopTargetDemo.request();
       }catch (Exception e){//捕获一下 代理不处理异常，还是要向外抛出
           e.printStackTrace();
           throw e;
       }
        System.out.println("我就等于After");
    }
}
