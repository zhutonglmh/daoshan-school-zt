package com.daoshan.school.demo.java_23_design_mode.create_modes.singleton_mode.Initialization;

/**
 * Initialization On Demand Holder idiom
 *
 * 基于类初始化的解决方案
 *
 * JVM在类的初始化阶段（即在Class被加载后，且被线程使用之前），会执行类的初始化。在执行类的初始化期间，JVM会去获取一个锁。这个锁可以同步多个线程对同一个类的初始化。
 *
 * 基于这个特性，可以实现另一种线程安全的延迟初始化方案（这个方案被称之为Initialization On Demand Holder idiom）：
 *
 * 初始化一个类，包括执行这个类的静态初始化和初始化在这个类中声明的静态字段。根据java语言规范，在首次发生下列任意一种情况时，一个类或接口类型T将被立即初始化：
 *
 *  T是一个类，而且一个T类型的实例被创建；
 *  T是一个类，且T中声明的一个静态方法被调用；
 *  T中声明的一个静态字段被赋值；
 *  T中声明的一个静态字段被使用，而且这个字段不是一个常量字段；
 *  T是一个顶级类（top level class，见java语言规范的§7.6），而且一个断言语句嵌套在T内部被执行。
 *
 *  这个方案的实质是：允许“问题的根源”的三行伪代码中的2和3重排序，但不允许非构造线程（这里指线程B）“看到”这个重排序。
 */
public class InstanceFactory {


    /**
     * 静态内部类
     */
    public static class InstanceHolder {

        //静态属性
        public static InstanceHolder instance = new InstanceHolder();

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static InstanceHolder getInstance() {
        
        return InstanceHolder.instance ;  //这里将导致InstanceHolder类被初始化

    }

}
