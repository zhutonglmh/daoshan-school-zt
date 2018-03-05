package com.daoshan.school.demo.java_23_design_mode.factory_mode.factory;

import com.daoshan.school.demo.java_23_design_mode.factory_mode.classer.AmdMainBoard;
import com.daoshan.school.demo.java_23_design_mode.factory_mode.classer.IntelMainBoard;
import com.daoshan.school.demo.java_23_design_mode.factory_mode.interfacer.MainBoard;

/**
 * cpu 工厂
 */
public class MainBoardFactory {

    public static MainBoard createMainBoard(int type){
        MainBoard mainBoard = null;
        if(type == 1){
            mainBoard = new IntelMainBoard(755);
        }else if(type == 2){
            mainBoard = new AmdMainBoard(938);
        }
        return mainBoard;
    }
}
