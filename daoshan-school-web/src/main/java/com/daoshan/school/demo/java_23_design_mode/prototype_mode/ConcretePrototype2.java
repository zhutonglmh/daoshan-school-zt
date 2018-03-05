package com.daoshan.school.demo.java_23_design_mode.prototype_mode;

import com.daoshan.school.demo.java_23_design_mode.prototype_mode.Prototype.AbstractProperty;
import com.daoshan.school.demo.java_23_design_mode.prototype_mode.Prototype.Prototype;

/**
 * 简单原型模式
 */
public class ConcretePrototype2 extends AbstractProperty {

    private String name2;

    private String code2;

    @Override
    public Prototype clone() {
        //最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
        ConcretePrototype2 prototype = new ConcretePrototype2();
        prototype.setName(this.name);
        prototype.setCode(this.code);
        prototype.setName2(this.name2);
        prototype.setCode2(this.code2);
        return prototype;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }
}
