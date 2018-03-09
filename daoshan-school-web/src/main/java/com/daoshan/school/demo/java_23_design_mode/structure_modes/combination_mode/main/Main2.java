package com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.main;

import com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.composite.ZbStore;
import com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.conponent.*;

/**
 * 2.应用组合模式的会员卡消费
 *
 * 那么我们就根据我们会员卡的消费，来模拟一下组合模式的实现吧！let's go！
 *
 * 首先：
 *
 * 1.我们的部件有，总店，分店，加盟店！
 *
 * 2.我们的部件共有的行为是：刷会员卡
 *
 * 3.部件之间的层次关系，也就是店面的层次关系是，总店下有分店、分店下可以拥有加盟店。
 *
 * 有了我们这几个必要条件后，我的要求就是目前店面搞活动当我在总店刷卡后，就可以累积相当于在所有下级店面刷卡的积分总额，设计的代码如下：
 *
 *
 *  4.什么情况下使用组合模式?
 *
 *  引用大话设计模式的片段：“当发现需求中是体现部分与整体层次结构时，以及你希望用户可以
 *  忽略组合对象与单个对象的不同，统一地使用组合结构中的所有对象时，就应该考虑组合模式了。”
 */
public class Main2 {

    public static void main(String[] args) {
        StroreRootNode zbStore = new ZbStore("总部门店");

        StroreRootNode fenStore1 =new FenStore1("分店1");
        StroreRootNode fenStore2 =new FenStore1("分店2");

        fenStore1.add(new JiaMengStore1("加盟店1"));
        fenStore1.add(new JiaMengStore2("加盟店2"));
        fenStore2.add(new JiaMengStore3("加盟店3"));
        fenStore2.add(new JiaMengStore4("加盟店4"));

        zbStore.add(fenStore1);
        zbStore.add(fenStore2);

        zbStore.MTC();
    }
}
