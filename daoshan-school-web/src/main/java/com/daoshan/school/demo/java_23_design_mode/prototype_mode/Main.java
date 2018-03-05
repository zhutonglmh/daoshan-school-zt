package com.daoshan.school.demo.java_23_design_mode.prototype_mode;

import com.daoshan.school.demo.java_23_design_mode.prototype_mode.Client.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式
 *
 * 浅克隆与深度克隆区别
 * 分析： Customer本身的属性值修改与原始对象并不冲突，它们都是各自一份，但集合类型修改后，克隆对象输出的与原始对象如出一辙，不难发现Cloneable的浅克隆范围只支持基本类型
 */
public class Main {

    //简单原型模式
    /*public static void main(String[] args) {

        ConcretePrototype1 concretePrototype1 = new ConcretePrototype1();
        concretePrototype1.setName("name");
        concretePrototype1.setCode("code");
        concretePrototype1.setCode3("name3");
        concretePrototype1.setName3("code3");
        List<String> list = new ArrayList<>();
        list.add("1");
        concretePrototype1.setList(list);
        Client client = new Client(concretePrototype1);
        ConcretePrototype1 concretePrototype11 = (ConcretePrototype1)client.operation();
        concretePrototype11.setName3("我改了");
        concretePrototype11.getList().add("2");
        //使用Cloneable浅clone() 只支持基本类型clone，其他包装类型拿的只是引用，修改会引发其他修改
        System.out.println(concretePrototype11);
        System.out.println(concretePrototype1);*/
    /*-----------------------------------------------------------------------------------------*/
      /*  ConcretePrototype3 concretePrototype3 = new ConcretePrototype3();
        concretePrototype3.setCode3("sdsd");
        ConcretePrototype3 concretePrototype31 = (ConcretePrototype3)concretePrototype3.clone();
        concretePrototype31.setCode3("dsds");
        System.out.println(concretePrototype3.getCode3());*/



      //------------------------------------------------------------------------------------------------

    /**
     * 通过序列化实现深度克隆
     *
     * 分析： 实现Serializable，通过序列化的方式与原始数据完全脱离关系，
     * 从而达到深度克隆效果，当然一般用SerializationUtils.clone(original)方式比我们自己写的会更好
     * @param args
     */
    public static void main(String[] args) throws Exception{
        ConcretePrototype1 concretePrototype1 = new ConcretePrototype1();
        concretePrototype1.setName("name");
        concretePrototype1.setCode("code");
        concretePrototype1.setCode3("name3");
        concretePrototype1.setName3("code3");
        List<String> list = new ArrayList<>();
        list.add("1");
        concretePrototype1.setList(list);
        ConcretePrototype1 concretePrototype11 = concretePrototype1.deepClone();
        concretePrototype11.getList().add("2");
        System.out.println(concretePrototype1);
        System.out.println(concretePrototype11);
    }


}

