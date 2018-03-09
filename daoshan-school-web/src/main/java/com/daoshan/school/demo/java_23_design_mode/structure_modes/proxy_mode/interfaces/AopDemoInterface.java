package com.daoshan.school.demo.java_23_design_mode.structure_modes.proxy_mode.interfaces;

/**
 * 演示 spring-aop  实现原理（静态代理）
 *
 * 总接口  包含了代理对象的方法 和 目标对象的方法
 */
public interface AopDemoInterface {

    /**
     * 必须有request() 方法
     */
    public void request();
}
