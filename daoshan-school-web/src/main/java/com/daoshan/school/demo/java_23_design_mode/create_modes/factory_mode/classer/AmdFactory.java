package com.daoshan.school.demo.java_23_design_mode.create_modes.factory_mode.classer;

import com.daoshan.school.demo.java_23_design_mode.create_modes.factory_mode.factory.AbstractFactory;
import com.daoshan.school.demo.java_23_design_mode.create_modes.factory_mode.interfacer.Cpu;
import com.daoshan.school.demo.java_23_design_mode.create_modes.factory_mode.interfacer.MainBoard;

/**
 * 抽象工厂模式
 */
public class AmdFactory implements AbstractFactory {

    @Override
    public Cpu CreateCpu() {
        return new AmdCpu(666);
    }

    @Override
    public MainBoard CreateMainBoardu() {
        return new AmdMainBoard(666);
    }
}
