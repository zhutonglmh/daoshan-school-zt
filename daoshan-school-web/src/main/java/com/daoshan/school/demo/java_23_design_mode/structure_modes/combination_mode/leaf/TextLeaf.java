package com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.leaf;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.conponent.Conponent;

/**
 * 叶子结点
 */
public class TextLeaf implements Conponent{

    private String name;

    //构造方法
    public TextLeaf(String name){
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("对文本文件 "+name+"进行杀毒！");
    }







    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
