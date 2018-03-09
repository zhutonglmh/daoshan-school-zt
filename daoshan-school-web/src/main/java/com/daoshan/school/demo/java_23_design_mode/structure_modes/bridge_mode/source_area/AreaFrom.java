package com.daoshan.school.demo.java_23_design_mode.structure_modes.bridge_mode.source_area;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.bridge_mode.bridge.Bridge;

/**
 * 抽象来源地A：AreaA
 */
public abstract class AreaFrom {

    /**
     * 引入桥接口
     */
    protected Bridge bridge;

    protected String areaName;

    /**
     * 来自于哪里？
     */
    protected abstract void comFrom();
}
