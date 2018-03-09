package com.daoshan.school.demo.java_23_design_mode.structure_modes.flyweight_mode.main;


import com.daoshan.school.demo.java_23_design_mode.structure_modes.flyweight_mode.fly_weight.FlyWeight;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.flyweight_mode.fly_weight_factory.FlyweightFactory;

/**
 * 享元模式
 *
 * Flyweight在拳击比赛中指最轻量级，即“蝇量级”或“雨量级”，这里选择使用“享元模式”的意译，
 * 是因为这样更能反映模式的用意。享元模式是对象的结构模式。享元模式以共享的方式高效地支持大量的细粒度对象。
 *
 *
 * Java中的String类型
 *　　在JAVA语言中，String类型就是使用了享元模式。String对象是final类型，对象一旦创建就不可改变。
 * 在JAVA中字符串常量都是存在常量池中的，JAVA会确保一个字符串常量在常量池中只有一个拷贝。String a="abc"，其中"abc"就是一个字符串常量。
 *
 * 　上面的例子中结果为：true ，这就说明a和b两个引用都指向了常量池中的同一个字符串常量"abc"。这样的设计避免了
 *   在创建N多相同对象时所产生的不必要的大量的资源消耗。
 *
 *
 *享元模式的结构
 *　享元模式采用一个共享来避免大量拥有相同内容对象的开销。这种开销最常见、最直观的就是内存的损耗。享元对象能做到共享的关键是区分内蕴状态(Internal State)和外蕴状态(External State)。
 *
 *　　一个内蕴状态是存储在享元对象内部的，并且是不会随环境的改变而有所不同。因此，一个享元可以具有内蕴状态并可以共享。
 *
 *　　一个外蕴状态是随环境的改变而改变的、不可以共享的。享元对象的外蕴状态必须由客户端保存，并在享元对象被创建之后，在需要使用的时候再传入到享元对象内部。外蕴状态不可以影响享元对象的内蕴状态，它们是相互独立的。
 *
 *　　享元模式可以分成单纯享元模式和复合享元模式两种形式。
 *
 *
 *
 *　单纯享元模式所涉及到的角色如下：
 *
 *　●　　抽象享元(Flyweight)角色 ：给出一个抽象接口，以规定出所有具体享元角色需要实现的方法。
 *
 *　●　　具体享元(ConcreteFlyweight)角色：实现抽象享元角色所规定出的接口。如果有内蕴状态的话，必须负责为内蕴状态提供存储空间。
 *
 *　●　　享元工厂(FlyweightFactory)角色 ：本角色负责创建和管理享元角色。本角色必须保证享元对象可以被系统适当地共享。当一个客户
 *       端对象调用一个享元对象的时候，享元工厂角色会检查系统中是否已经有一个符合要求的享元对象。如果已经有了，享元工厂角色就应当
 *       提供这个已有的享元对象；如果系统中没有一个适当的享元对象的话，享元工厂角色就应当创建一个合适的享元对象。
 *
 *
 *
 *
 */
public class Main {

    // == 比较的是两个对象引用的内存地址是否相同
    //Java 语言里的 equals方法其实是交给开发者去覆写的，让开发者自己去定义满足什么条件的两个Object是equal的。
    //所以我们不能单纯的说equals到底比较的是什么。你想知道一个类的equals方法是什么意思就是要去看定义。*/
//    public static void main(String[] args) {
//
//        Demo demo = new Demo();
//        Demo demo1 = new Demo();
//        System.out.println(demo.equals(demo1));
//
//        String str1 = new String("1");
//        String str2 = "1";
//        System.out.println(str1.equals(str2));//true
//
//        String str3 = new String("1");
//        String str4 = "1";
//        System.out.println(str1==str2);//false
//    }


    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        FlyWeight fly = factory.factory(new Character('a'));
        fly.operation("First Call");

        fly = factory.factory(new Character('b'));
        fly.operation("Second Call");

        fly = factory.factory(new Character('a'));
        fly.operation("Third Call");
    }
}
