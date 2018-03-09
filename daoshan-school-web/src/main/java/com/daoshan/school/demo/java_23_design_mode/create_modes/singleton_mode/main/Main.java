package com.daoshan.school.demo.java_23_design_mode.create_modes.singleton_mode.main;

import com.daoshan.school.demo.java_23_design_mode.create_modes.singleton_mode.Initialization.InstanceFactory;
import com.daoshan.school.demo.java_23_design_mode.create_modes.singleton_mode.double_check_lock.Doublechecklock;
import com.daoshan.school.demo.java_23_design_mode.create_modes.singleton_mode.e_han_shi.EagerSingleton;
import com.daoshan.school.demo.java_23_design_mode.create_modes.singleton_mode.lan_han_shi.LazySingleton;

/**
 * 单例模式
 *
 * 　作为对象的创建模式，单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。这个类称为单例类。
 *
 *   特点：
 *   单例类只能有一个实例。
 *    单例类必须自己创建自己的唯一实例。
 *    单例类必须给所有其他对象提供这一实例。
 */
public class Main {
    public static void main(String[] args) {

        //测试饿汉式
        EagerSingleton eagerSingleton = EagerSingleton.getEagerSingleton();
        System.out.println("未修改前："+eagerSingleton.getName());
        eagerSingleton.setName("xiaomei");
        EagerSingleton eagerSingleton1 = EagerSingleton.getEagerSingleton();
        System.out.println("修改后："+eagerSingleton.getName());

        //测试懒汉式LazySingleton
        LazySingleton lazySingleton = LazySingleton.getLazySingleton();
        System.out.println("未修改前："+lazySingleton.getName());
        eagerSingleton.setName("xiaomei");
        LazySingleton lazySingleton1 = LazySingleton.getLazySingleton();
        System.out.println("修改后："+lazySingleton1.getName());

        //测试双重检查加锁懒汉式
        Doublechecklock doublechecklock = Doublechecklock.getDoublechecklock();
        System.out.println("未修改前："+doublechecklock.getName());
        eagerSingleton.setName("xiaomei");
        Doublechecklock doublechecklock1 = Doublechecklock.getDoublechecklock();
        System.out.println("修改后："+doublechecklock.getName());

        //测试基于类初始化的解决方案
         InstanceFactory.InstanceHolder instanceHolder = InstanceFactory.getInstance();
        instanceHolder.setName("zhutong");
        System.out.println("未修改前："+instanceHolder.getName());
        InstanceFactory.InstanceHolder instanceHolder1 = InstanceFactory.getInstance();
        instanceHolder1.setName("xiaomei");
        System.out.println("修改后："+instanceHolder.getName());

    }
}
