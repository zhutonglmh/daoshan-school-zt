package com.daoshan.school.demo.java_23_design_mode.behavior_modes.responsibility_chain.concreteHandlers;

import com.daoshan.school.demo.java_23_design_mode.behavior_modes.responsibility_chain.abstractHandler.AbstractHandler;

/**
 *
 * 具体处理者（级别  总经理）
 *
 *
 */
public class ConcreteHandler2 extends AbstractHandler {


    public ConcreteHandler2(AbstractHandler abstractHandler){
        super.abstractHandler = abstractHandler;
    }
    public ConcreteHandler2(){

    }
    @Override
    public void handle(String user, Double fee) {

        System.out.println("总经理已经接收到"+user+"资金"+fee+"的审批请求");
        if(fee <= 2000){
            System.out.println("总经理已经同意了"+user+"资金"+fee+"的审批请求");
        }else {
            System.out.println("总经理无权处理"+user+"资金"+fee+"的审批请求!已移交上级");
            if(null != abstractHandler){
                abstractHandler.handle(user,fee);
            }else {
                System.out.println("无人处理");
            }
        }
    }
}
