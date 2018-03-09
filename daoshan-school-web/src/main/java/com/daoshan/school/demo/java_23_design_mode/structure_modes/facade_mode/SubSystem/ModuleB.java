package com.daoshan.school.demo.java_23_design_mode.structure_modes.facade_mode.SubSystem;

/**
 * 子系统 模块B   缴费
 */
public class ModuleB {

    //供外部调用
    public void jiaofei(){
        System.out.println("已完成缴费！");
    }

    //供内部调用
    public void b1(){}
}
