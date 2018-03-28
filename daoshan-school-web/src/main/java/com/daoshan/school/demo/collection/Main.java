package com.daoshan.school.demo.collection;


import com.daoshan.school.demo.java8.demo.list操作问题.Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试list遍历 remove 问题     答案 ： 移除坐标不可以  但是根据对象移除可以
 *
 */
public class Main {

    public static void main(String[] args) {

        List<Demo> list = new ArrayList<>();

        for (int i=0;i<100;i++){
            Demo demo = new Demo(i);
            list.add(demo);
        }

        int size = list.size();
        for (int i = 0;i<size;i++) {
            Demo demo = list.get(0);
            System.out.println("***********----------"+demo.getId());
            list.remove(demo);
        }

    }
}
