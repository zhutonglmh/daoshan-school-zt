package com.daoshan.school.demo.java.匿名内部类.Main.interfaces;


/**
 * 匿名内部类实现接口
 */
public abstract class Bird {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract int fly2();

    public abstract int fly();


}