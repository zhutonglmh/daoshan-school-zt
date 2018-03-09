package com.daoshan.school.demo.java_23_design_mode.create_modes.singleton_mode.double_check_lock;


/**
 *  懒加载-单例模式-双重检查加锁
 */
public class Doublechecklock {        //1

    //private static Doublechecklock doublechecklock = null;  //2

    private String name = "zhutong";
    private volatile static Doublechecklock doublechecklock = null;  //基于volatile的双重检查锁定的解决方案   解决拿到对象引用但是实际上对象还没初始化完成这个问题

    //私有化构造方法
    private Doublechecklock(){

    }

    public static Doublechecklock getDoublechecklock(){  //3

        if(doublechecklock == null){           //4  第一次判断
            synchronized (Doublechecklock.class){      //5  加锁
                if(doublechecklock == null){      //6 第二次判断
                    doublechecklock = new Doublechecklock();  //7 可能会出现一些线程安全问题的，
                    /**
                     *
                     *
                     *   如上面代码所示，如果第一次检查instance不为null，那么就不需要执行下面的加锁和初始化操作。因此可以大幅降低synchronized带来的性能开销。上面代码表面上看起来，似乎两全其美：
                     *
                     *  在多个线程试图在同一时间创建对象时，会通过加锁来保证只有一个线程能创建对象。
                     *   在对象创建好之后，执行getInstance()将不需要获取锁，直接返回已创建好的对象。
                     *   双重检查锁定看起来似乎很完美，但这是一个错误的优化！在线程执行到第4行代码读取到instance不为null时，instance引用的对象有可能还没有完成初始化。
                     *
                     * 前面的双重检查锁定示例代码的第7行（doublechecklock = new Doublechecklock();）
                     * 创建一个对象。这一行代码可以分解为如下的三行伪代码：
                     *
                     *
                     * memory = allocate();   //1：分配对象的内存空间
                     * ctorInstance(memory);  //2：初始化对象
                     * instance = memory;     //3：设置instance指向刚分配的内存地址
                     * 上面三行伪代码中的2和3之间，可能会被重排序（在一些JIT编译器上，这种重排序是真实发生的，详情见参考文献1的“Out-of-order writes”部分
                     *
                     * 基于volatile的双重检查锁定的解决方案
                     * 简单地说就是防止编译器对代码进行优化。比如如下程序：
                     * XBYTE[2]=0x55;
                     * XBYTE[2]=0x56;
                     * XBYTE[2]=0x57;
                     * XBYTE[2]=0x58;
                     * 对外部硬件而言，上述四条语句分别表示不同的操作，会产生四种不同的动作，但是编译器却会对上述四条语句进行优化，认为只有XBYTE[2]=0x58（即忽略前三条语句，只产生一条机器代码）。如果键入volatile，则编译器会逐一地进行编译并产生相应的机器代码（产生四条代码）。
                     * 解决方式：    1、不允许2和3重排序； 基于volatile的双重检查锁定的解决方案
                     *              2、允许2和3重排序，但不允许其他线程“看到”这个重排序。
                     */
                }
            }
        }
        return doublechecklock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
