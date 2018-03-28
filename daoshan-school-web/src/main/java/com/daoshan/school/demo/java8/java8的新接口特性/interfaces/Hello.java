package com.daoshan.school.demo.java8.java8的新接口特性.interfaces;

/**
 *
 * 测试java8 新特性   default 和 static
 */
public interface Hello {

    //正常方法
    String showName();


    //默认方法
    default String showName2(String name){
        System.out.println(name);
        return name;
    }

    //静态方法
    static String showName3(String name){
        System.out.println(name);
        return name;
    }


}

