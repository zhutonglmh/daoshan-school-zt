package com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.main;


import com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.composite.Composite;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.conponent.Conponent;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.leaf.ImgeLeaf;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.leaf.TextLeaf;

/**
 * 组合模式
 *
 *
 * 把部分和整体的关系用树形结构来表示，从而使客户端可以使用统一的方式对部分对象和整体对象进行管理。
 *
 *下面通过简单的杀毒例子，使用组合模式：
 *
 * 组合模式结构
 *
 * 抽象构件(Conponent)角色：所有类的共有接口，定义了叶子和容器的共同点。
 * 叶子(Leaf)构件角色:在组合中表示叶子结点对象，叶子节点无子节点。
 * 容器(Composite)构件角色：有容器特征，可以 用来存储子节点，在Component接口中实现与子节点有关操作，如增加(add)和删除 (remove)等。
 *
 *  3.什么情况下使用组合模式
 *
 *  引用大话设计模式的片段：“当发现需求中是体现部分与整体层次结构时，以及你希望用户可以
 *  忽略组合对象与单个对象的不同，统一地使用组合结构中的所有对象时，就应该考虑组合模式了。”
 *
 */
public class Main {


    //测试组合模式
    public static void main(String[] args) {

        //创建父节点对象
        Composite conposite = new Composite();

        //创建叶子节点对象
        Conponent conponent = new ImgeLeaf("my.jpg");
        Conponent conponent2 = new TextLeaf("my.txt");

        //添加到父节点
        conposite.add(conponent);
        conposite.add(conponent2);

        conposite.killVirus();
    }
}
