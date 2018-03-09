package com.daoshan.school.demo.java_23_design_mode.structure_modes.facade_mode.SubSystem;

/**
 * 子系统 模块c   取药
 */
public class ModuleC {

    //供外部调用
    public void quyao(){
        System.out.println("已完成取药！");
    }

    //供内部调用
    public void c1(){}
}
