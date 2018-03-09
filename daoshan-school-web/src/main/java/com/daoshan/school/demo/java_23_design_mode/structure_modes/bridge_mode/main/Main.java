package com.daoshan.school.demo.java_23_design_mode.structure_modes.bridge_mode.main;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.bridge_mode.a_from.Area_A;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.bridge_mode.b_target.TargetA;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.bridge_mode.bridge.Bridge;

/**
 *
 *  桥接模式
 *
 * 　这里摘抄一份他处的概念，你可以不必理会，先看下面得讲解与实例，然后返回来理解概念，不然抽象的概念会让你崩溃...
 *
 *　　桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。这种类型的设计模式属于结构型模式，它通过提供抽象化和实现化之间的桥接结构，来实现二者的解耦。
 *
 *　　这种模式涉及到一个作为桥接的接口，使得实体类的功能独立于接口实现类。这两种类型的类可被结构化改变而互不影响。
 *
 *　　个人理解：桥接是一个接口，它与一方应该是绑定的，也就是解耦的双方中的一方必然是继承这个接口的，这一方就是实现方，而另一方正是要与这一方解耦的抽象方，
 *   如果不采用桥接模式，一般我们的处理方式是直接使用继承来实现，这样双方之间处于强链接，类之间关联性极强，如要进行扩展，必然导致类结构急剧膨胀。采用桥接模式，
 *   正是为了避免这一情况的发生，将一方与桥绑定，即实现桥接口，另一方在抽象类中调用桥接口（指向的实现类），这样桥方可以通过实现桥接口进行单方面扩展，
 *   而另一方可以继承抽象类而单方面扩展，而之间的调用就从桥接口来作为突破口，不会受到双方扩展的任何影响。
 *
 *　　下面的实例能真正体现着一点：
 *
 * 　实例准备：我们假设有一座桥，桥左边为A，桥右边为B，A有A1，A2，A3等，表示桥左边的三个不同地方，B有B1，B2，B3等，表示桥右边的三个不同地方，
 *   假设我们要从桥左侧A出发到桥的右侧B，我们可以有多重方案，A1到B1，A1到B2，A1到B3，A2到B1...等等，以此为例，代码如下：
 */
public class Main {

    public static void main(String[] args) {

        //设置目的地
        Bridge target = new TargetA("A");
        //设置出发地
        Area_A  a = new Area_A("1",target);

        a.comFrom();
    }
}
