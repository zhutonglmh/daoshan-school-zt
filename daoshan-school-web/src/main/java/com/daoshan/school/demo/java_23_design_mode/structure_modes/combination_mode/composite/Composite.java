package com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.composite;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.conponent.Conponent;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Conponent{


    private String name;

    private List<Conponent> list = new ArrayList<>();

    //添加节点
    public void add(Conponent conponent){
        this.list.add(conponent);
    }

    //移除节点
    public void remove(Conponent conponent){
        this.list.remove(conponent);
    }

    //获取第几个节点
    public Conponent getLeaf(int i){
        return list.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("对文件夹"+name+"进行杀毒！");

        for (Conponent conponent:list) {
            conponent.killVirus();
        }
    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Conponent> getList() {
        return list;
    }

    public void setList(List<Conponent> list) {
        this.list = list;
    }
}
