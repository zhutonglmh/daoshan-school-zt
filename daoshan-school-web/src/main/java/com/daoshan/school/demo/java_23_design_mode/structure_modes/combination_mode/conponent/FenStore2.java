package com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.conponent;

/**
 * 分店节点2
 */
public class FenStore2 extends AbstracterRoot{


    public FenStore2(String name){
        super.name = name;
    }
    @Override
    public void MTC() {
        System.out.println("开始遍历"+name+"节点");
        for (StroreRootNode stroreRootNode : list) {
            stroreRootNode.MTC();
        }
    }

    @Override
    public void add(StroreRootNode stroreRootNode) {
        this.list.add(stroreRootNode);
    }

    @Override
    public void remove(StroreRootNode stroreRootNode) {
        this.list.remove(stroreRootNode);
    }
}
