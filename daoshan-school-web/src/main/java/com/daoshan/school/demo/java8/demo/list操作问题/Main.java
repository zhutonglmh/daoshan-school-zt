package com.daoshan.school.demo.java8.demo.list操作问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) {

       List<Demo> list1 = new ArrayList<>();
       List<Demo2> list2 = new ArrayList<>();
       for(int i=0;i<100;i++){
           Demo demo = new Demo(i);
           list1.add(demo);
       }

        for(int i=0;i<100;i++){
            Demo2 demo2 = new Demo2(i+37);
            list2.add(demo2);
        }

        //取两个集合中id相同的地方
        List<Demo> list3 = new ArrayList<>();
        for (Demo map : list1) {
            Demo demo = list2.stream()
                    .filter(m -> Objects.equals(m.getDemoId(), map.getId()))
                    .findFirst().map(m -> {
                        map.setId(m.getDemoId());
                        return map;
                    }).orElse(null);
            if (demo != null) {
                list3.add(demo);
            }
        }

        System.out.println(list3);

    }
}
