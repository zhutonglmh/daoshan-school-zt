package com.daoshan.school.demo.java_23_design_mode.prototype_mode;

import com.daoshan.school.demo.java_23_design_mode.prototype_mode.Prototype.AbstractProperty;
import lombok.Data;

import java.io.Serializable;
import java.lang.Object;
/**
 * 简单原型模式
 */
@Data
public class ConcretePrototype3 implements Serializable {


    private String name3;

    private String code3;

    @Override
    public Object clone(){
        Object clone = null;
        try {
            clone  =  super.clone();
        }catch (CloneNotSupportedException e){
            e.getCause();
        }
        return clone;
    }


    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }
}
