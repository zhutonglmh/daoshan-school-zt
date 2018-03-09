package com.daoshan.school.demo.java_23_design_mode.structure_modes.flyweight_mode.fly_weight;


/**
 * 抽象享元接口  给出一个抽象接口，以规定出所有具体享元角色需要实现的方法。
 *
 */
public interface FlyWeight {

    //一个示意性方法，参数state是外蕴状态
    public void operation(String state);
}
