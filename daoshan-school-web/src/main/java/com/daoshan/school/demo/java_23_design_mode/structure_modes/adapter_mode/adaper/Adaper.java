package com.daoshan.school.demo.java_23_design_mode.structure_modes.adapter_mode.adaper;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.adapter_mode.adapee.Adapee;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.adapter_mode.target.Target;

/**
 * 类适配器模式
 *
 * 适配器角色
 *
 *
 * 通过继承源角色  实现源角色与目标角色的配对
 */
public class Adaper extends Adapee implements Target{

    @Override
    public void operation2() {

    }
}
