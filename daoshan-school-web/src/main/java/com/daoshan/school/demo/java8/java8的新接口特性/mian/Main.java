package com.daoshan.school.demo.java8.java8的新接口特性.mian;

import com.daoshan.school.demo.java8.java8的新接口特性.interfaces.Hello;
import com.daoshan.school.demo.java8.java8的新接口特性.interfaces.HelloImpl;

/**
 * 测试java8 的新接口特性
 *
 */
public interface Main {

    public static void main(String[] args) {

        Hello hello = new HelloImpl();

        //正常调用
        hello.showName();

        //调用default方法
        hello.showName2("调用default方法");

        //调用接口之中的静态方法
        Hello.showName3("调用接口之中的静态方法");
    }
}
