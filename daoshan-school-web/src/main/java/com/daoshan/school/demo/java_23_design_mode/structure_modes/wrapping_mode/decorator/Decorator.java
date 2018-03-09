package com.daoshan.school.demo.java_23_design_mode.structure_modes.wrapping_mode.decorator;


import com.daoshan.school.demo.java_23_design_mode.structure_modes.wrapping_mode.component.Component;

/**
 * 装饰(Decorator)角色
 *
 * 持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口。
 */
public class Decorator implements Component{

    //持有一个构件(Component)对象的实例
    protected Component component;

    public Decorator(Component component){
        this.component = component;
    }
    //原有对象的方法
    @Override
    public void sampleOperation() {

        // 委派给构件
        component.sampleOperation();
    }
}
