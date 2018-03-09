package com.daoshan.school.demo.java_23_design_mode.create_modes.singleton_mode.e_han_shi;

/**
 * 饿汉式
 *
 * 空间换时间
 * 私有化构造方法
 * 加载静态变量时对象创建
 *
 */
public class EagerSingleton {

    //静态私有变量
    private static EagerSingleton eagerSingleton = new EagerSingleton();

    //
    private String name = "zhutong";
    //私有构造方法
    private EagerSingleton(){
        System.out.println("我被初始化");
    }

    public static EagerSingleton getEagerSingleton() {
        return eagerSingleton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
