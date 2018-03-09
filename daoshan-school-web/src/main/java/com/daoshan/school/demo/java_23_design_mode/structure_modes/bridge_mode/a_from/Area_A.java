package com.daoshan.school.demo.java_23_design_mode.structure_modes.bridge_mode.a_from;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.bridge_mode.bridge.Bridge;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.bridge_mode.source_area.AreaFrom;

/**
 * 出发地 A
 *
 * 1，实例化子类不会去自动实例化父类，因为父类有可能是抽象类，抽象类是不能被实例化的
 *
 * 2，不是获得父类的变量，而是子类自己的变量了，你可以创两个不一样的子类，父类的字段给不一样的值都可以，说明这个字段实在子类中单独实例化
 *
 * 类的继承只是一个定义方式，或者说是一种设计模式，恐怕你要加强面向对象概念性的学习
 */
public class Area_A extends AreaFrom {

    public Area_A(String str,Bridge target){
        super.areaName = str;
        super.bridge = target;
    }
    /**
     * 来自于哪里？要去哪里
     */
    @Override
    public void comFrom() {
        System.out.println("我来自"+areaName);
        bridge.areaTarget();
    }
}
