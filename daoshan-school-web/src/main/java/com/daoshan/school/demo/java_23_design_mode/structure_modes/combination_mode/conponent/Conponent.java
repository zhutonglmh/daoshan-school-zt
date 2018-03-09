package com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.conponent;


/**
 * 组合模式  抽象构建
 *
 * 以杀毒为例
 *
 * 抽象构件(Conponent)角色：所有类的共有接口，定义了叶子和容器的共同点。
 *
 */
public interface Conponent {

    //杀毒
    void killVirus();
}
