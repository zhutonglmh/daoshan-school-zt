package com.daoshan.school.demo.java_23_design_mode.prototype_mode;

import com.daoshan.school.demo.java_23_design_mode.prototype_mode.Prototype.AbstractProperty;
import com.daoshan.school.demo.java_23_design_mode.prototype_mode.Prototype.Prototype;
import lombok.Data;

import java.io.*;
import java.util.List;

/**
 * 简单原型模式
 */
public class ConcretePrototype1 extends AbstractProperty implements Serializable{

    private static final long serialVsersionUID = 1L;
    private String name3;

    private String code3;

    private List<String> list;

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

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    //深度克隆
    protected ConcretePrototype1 deepClone() throws Exception {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(this);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bis);
        return (ConcretePrototype1)in.readObject();
    }
}
