package com.daoshan.school.demo.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * map 中 存 list  存的是引用还是新list
 */
public class Main2 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        HashMap<String,List<String>> map = new HashMap<>();

        list.add("朱同");
        list.add("朱同");
        list.add("朱同");

        map.put("zhutong",list);

        list.clear();

        list.add("鑫斌");
        list.add("鑫斌");
        list.add("鑫斌");

        map.put("xinbin",list);

        System.out.println(map.get("zhutong"));

    }
}
