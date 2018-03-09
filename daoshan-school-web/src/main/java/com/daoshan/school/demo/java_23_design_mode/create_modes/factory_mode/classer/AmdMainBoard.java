package com.daoshan.school.demo.java_23_design_mode.create_modes.factory_mode.classer;

import com.daoshan.school.demo.java_23_design_mode.create_modes.factory_mode.interfacer.MainBoard;

public class AmdMainBoard implements MainBoard {

    private int cpuHoles = 0;

    public AmdMainBoard(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }
    /**
     * 安装cpu
     */
    @Override
    public void installCPU() {
        System.out.println("amd 插槽孔数："+cpuHoles);
    }
}
