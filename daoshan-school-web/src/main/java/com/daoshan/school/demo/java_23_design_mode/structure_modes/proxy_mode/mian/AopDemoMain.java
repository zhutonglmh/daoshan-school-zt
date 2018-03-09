package com.daoshan.school.demo.java_23_design_mode.structure_modes.proxy_mode.mian;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.proxy_mode.proxyFactory.CjlibProxyFactory;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.proxy_mode.target.CjlibTarget;

/**
 * 演示aop的实现原理
 */
public class AopDemoMain {

   /*(静态代理)
    public static void main(String[] args) {

        AopDemoInterface aop = new AopDemoImpl(new AopTargetDemo()); //使用代理类

        aop.request();
    }*/

    //jdk 动态代理   http://rejoy.iteye.com/blog/1627405
    //    动态代理有以下特点:
    // 1.代理对象,不需要实现接口
    // 2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
    // 3.动态代理也叫做:JDK代理,接口代理
    // 特别注意：代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理

   /* public static void main(String[] args) {

        AopJdkTargetDemo aopJdkTargetDemo = new AopJdkTargetDemo();
        JdkProxySubject jdkProxySubject = new JdkProxySubject(aopJdkTargetDemo);
        AopJdkTargetDemoInterface proxy = (AopJdkTargetDemoInterface)jdkProxySubject.getProxy();
       // AopJdkTargetDemo aopJdkTargetDemo1 = (AopJdkTargetDemo)proxy;
        proxy.showName("我是朱同同");
    }*/


    //1.3 Cglib 代理    https://www.cnblogs.com/cenyu/p/6289209.html
    //上面的静态代理和动态代理模式都是要求目标对象是实现一个接口的目标对象,但是有时候目标对象只是一个单独的对象,并没有实现任何的接口,这个时候就可以使用以目标对象子类的方式类实现代理,这种方法就叫做:Cglib代理

   /* Cglib代理,也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展.

       JDK的动态代理有一个限制,就是使用动态代理的对象必须实现一个或多个接口,如果想代理没有实现接口的类,就可以使用Cglib实现.
       Cglib是一个强大的高性能的代码生成包,它可以在运行期扩展java类与实现java接口.它广泛的被许多AOP的框架使用,例如Spring AOP和synaop,为他们提供方法的interception(拦截)
       Cglib包的底层是通过使用一个小而块的字节码处理框架ASM来转换字节码并生成新的类.不鼓励直接使用ASM,因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉.

       Cglib子类代理实现方法:
          1.需要引入cglib的jar文件,但是Spring的核心包中已经包括了Cglib功能,所以直接引入pring-core-3.2.5.jar即可.
          2.引入功能包后,就可以在内存中动态构建子类
          3.代理的类不能为final,否则报错
          4.目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.*/
    public static void main(String[] args) {
        //新建目标类实例
        CjlibTarget cjlibTarget = new CjlibTarget("朱同同");
        //获取代理工程
        CjlibProxyFactory cjlibProxyFactory = new CjlibProxyFactory(cjlibTarget);
        //拿到代理
        CjlibTarget cjlibTarget1 = (CjlibTarget)cjlibProxyFactory.getProxyInstance();
        //通过代理调用目标方法
        cjlibTarget1.showName();
    }
}
