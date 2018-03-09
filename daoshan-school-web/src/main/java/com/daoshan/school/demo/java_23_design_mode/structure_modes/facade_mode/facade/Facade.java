package com.daoshan.school.demo.java_23_design_mode.structure_modes.facade_mode.facade;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.facade_mode.SubSystem.ModuleA;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.facade_mode.SubSystem.ModuleB;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.facade_mode.SubSystem.ModuleC;

/**
 * 门面模式（外观模式）  一个子系统只有一个门面类(所以他是单例，使用静态内部类的方式实现单例)
 */
public class Facade {

    //静态内部类
    public static class Facade1{

        private static Facade1 facade1= new Facade1();

        //构造方法
        private Facade1(){}

        //去医院买药
        public void goToHospital(){

            //挂号
            new ModuleA().guahao();
            //缴费
            new ModuleB().jiaofei();
            //取药
            new ModuleC().quyao();
        }
    }

    public static Facade1 getFacade1(){

        return Facade1.facade1;
    }

}
