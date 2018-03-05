package com.daoshan.school.demo.java_23_design_mode.factory_mode.classer;

import com.daoshan.school.demo.java_23_design_mode.factory_mode.interfacer.Cpu;

public class AmdCpu implements Cpu {

    /**
     * cpu针脚数
     */
    private int pins;

    public AmdCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("amd ++ 针脚数：" + pins);
    }
}
