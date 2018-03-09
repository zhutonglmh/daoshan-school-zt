package com.daoshan.school.demo.java_23_design_mode.create_modes.singleton_mode.lan_han_shi;

/**
 * 懒汉式 时间换空间
 *
 * 线程安全
 */
public class LazySingleton {

    private String name = "zhutong";

    private static LazySingleton lazySingleton;
    //私有化构造方法
    private LazySingleton(){}

    //线程安全
    public static synchronized LazySingleton getLazySingleton(){
        if(null != lazySingleton){
            return lazySingleton;
        }else {
            return new LazySingleton();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
