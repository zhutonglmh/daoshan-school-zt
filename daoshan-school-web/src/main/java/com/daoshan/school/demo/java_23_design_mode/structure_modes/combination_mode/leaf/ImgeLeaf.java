package com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.leaf;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.conponent.Conponent;

/**
 *
 * 叶子(Leaf)构件角色:在组合中表示叶子结点对象，叶子节点无子节点
 */
public class ImgeLeaf implements Conponent{

    public ImgeLeaf(String name){
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("对图像文件"+name+"进行杀毒！");
    }

}
