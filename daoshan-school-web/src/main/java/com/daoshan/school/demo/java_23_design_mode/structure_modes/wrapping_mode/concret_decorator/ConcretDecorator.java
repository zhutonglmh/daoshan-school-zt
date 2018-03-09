package com.daoshan.school.demo.java_23_design_mode.structure_modes.wrapping_mode.concret_decorator;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.wrapping_mode.component.Component;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.wrapping_mode.decorator.Decorator;

/**
 *
 * 具体装饰(ConcreteDecorator)角色：
 *
 * 负责给构件对象“贴上”附加的责任。
 */
public class ConcretDecorator extends Decorator {

    //父类构造方法有参  子类必须保持一致
    public ConcretDecorator(Component component) {

        super(component);
    }

    //所需要扩展的方法
    public void sampleOperation(){
        component.sampleOperation();
        this.sampleOperation1();
    }

    //所需要扩展的方法
    public void sampleOperation1(){
        System.out.println("扩展方法！");
    }
}
