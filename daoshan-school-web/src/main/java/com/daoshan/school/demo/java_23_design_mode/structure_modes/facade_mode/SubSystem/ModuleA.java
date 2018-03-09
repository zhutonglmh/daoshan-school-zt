package com.daoshan.school.demo.java_23_design_mode.structure_modes.facade_mode.SubSystem;

/**
 * 子系统 模块a   挂号
 */
public class ModuleA {

    //供外部使用
    public void guahao(){
        System.out.println("已完成挂号！");
    }

    //供内部调用
    public void a1(){}

}
