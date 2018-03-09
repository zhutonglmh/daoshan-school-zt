package com.daoshan.school.demo.java_23_design_mode.structure_modes.wrapping_mode.concrete_component;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.wrapping_mode.component.Component;

/**
 *
 * 包装模式
 *
 * 具体构件(ConcreteComponent)角色：定义一个将要接收附加责任的类。
 *
 */
public class ConcreteComponent implements Component {

    @Override
    public void sampleOperation() {
        System.out.println("原有方法！");
    }
}
