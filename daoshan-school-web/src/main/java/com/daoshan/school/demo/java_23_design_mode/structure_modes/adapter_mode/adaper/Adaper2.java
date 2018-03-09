package com.daoshan.school.demo.java_23_design_mode.structure_modes.adapter_mode.adaper;


import com.daoshan.school.demo.java_23_design_mode.structure_modes.adapter_mode.adapee.Adapee2;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.adapter_mode.target.Target;

/**
 * 适配器模式
 *
 * 对象适配器角色
 *
 *
 * 通过代理调用源角色方法源角色  实现源角色与目标角色的配对
 */
public class Adaper2 implements Target {


    @Override
    public void operation1() {
        Adapee2 adapee2 = new Adapee2();
        adapee2.operation1();
    }

    @Override
    public void operation2() {

    }
}
