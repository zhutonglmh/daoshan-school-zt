package com.daoshan.school.demo.java_23_design_mode.structure_modes.bridge_mode.b_target;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.bridge_mode.bridge.Bridge;

public class TargetA implements Bridge{

    private String targetName;
    public TargetA(String str){
        this.targetName = str;
    }
    @Override
    public void areaTarget() {
        System.out.println("我要去"+targetName);
    }
}
