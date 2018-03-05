package com.daoshan.school.demo.java_23_design_mode.factory_mode.factory;

import com.daoshan.school.demo.java_23_design_mode.factory_mode.interfacer.Cpu;
import com.daoshan.school.demo.java_23_design_mode.factory_mode.interfacer.MainBoard;

/**
 * 抽象工厂模式
 */
public interface AbstractFactory {

    public Cpu CreateCpu();

    public MainBoard CreateMainBoardu();
}
