package com.daoshan.school.demo.java_23_design_mode.structure_modes.combination_mode.conponent;

import java.util.ArrayList;
import java.util.List;

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
 * 即在父节点刷卡后  子节点相应改变
 *
 * 根节点抽象类  其他子类继承该抽象类
 */
public abstract class AbstracterRoot implements StroreRootNode{

    //该节点下子节点列表集合
    protected List<StroreRootNode> list = new ArrayList<>();
    //门店名称
    protected String name;

}
