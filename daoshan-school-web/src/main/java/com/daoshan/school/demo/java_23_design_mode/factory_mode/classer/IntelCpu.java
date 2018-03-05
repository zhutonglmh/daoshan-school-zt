package com.daoshan.school.demo.java_23_design_mode.factory_mode.classer;

import com.daoshan.school.demo.java_23_design_mode.factory_mode.interfacer.Cpu;

public class IntelCpu implements Cpu {

    /**
     * cpu的针脚数
     */
    private int pins;

    /**
     * 构造方法
     * @param pins
     */
    public IntelCpu(int pins){
        this.pins = pins;
    }

    /**
     * cpu 功能
     */
    @Override
    public void calculate() {
        System.out.println("intel ++针脚数："+pins);
    }
}
