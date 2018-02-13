package com.daoshan.school.controller.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class demo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

       Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String  ss = iterator.next();
            if(ss.equals("1")){
                iterator.remove();
            }
            else if(ss.equals("2")){
                iterator.remove();
            }
            System.out.println(iterator);
            System.out.println(iterator.hasNext());
        }
        for (String ss : list){
            System.out.println(ss);
        }
    }
}
