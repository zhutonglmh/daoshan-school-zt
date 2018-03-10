package com.daoshan.school.demo.java_23_design_mode.behavior_modes.responsibility_chain.abstractHandler;

/**
 *
 * 抽象处理者(Handler)角色：定义出一个处理请求的接口。如果需要，接口可以定义 出一个方法以设定和返回对下家的引用。
 * 这个角色通常由一个Java抽象类或者Java接口实现。上图中Handler类的聚合关系给出了具体子类对下家的引用，
 * 抽象方法handleRequest()规范了子类处理请求的操作。
 *
 *
 */
public abstract class AbstractHandler{

    //上级处理者
    protected AbstractHandler abstractHandler;

    public abstract void handle(String user,Double fee);
}
