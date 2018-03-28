package com.daoshan.school.demo.java8.java8的新接口特性.interfaces;

public class HelloImpl implements Hello{

    @Override
    public String showName() {
        System.out.println("我是一个正常的接口实现");
        return null;
    }
}
