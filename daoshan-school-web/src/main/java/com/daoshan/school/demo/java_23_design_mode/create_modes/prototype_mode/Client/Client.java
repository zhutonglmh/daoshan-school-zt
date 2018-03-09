package com.daoshan.school.demo.java_23_design_mode.create_modes.prototype_mode.Client;

import com.daoshan.school.demo.java_23_design_mode.create_modes.prototype_mode.Prototype.Prototype;

public class Client {
    /**
     * 持有需要使用的原型接口对象
     */
    private Prototype prototype;
    /**
     * 构造方法，传入需要使用的原型接口对象
     */
    public Client(Prototype prototype){
        this.prototype = prototype;
    }
    public Prototype operation(){

        //需要创建原型接口的对象
        Prototype copyPrototype = (Prototype)prototype.clone();

        System.out.println(copyPrototype.toString());
        return copyPrototype;
    }
}
