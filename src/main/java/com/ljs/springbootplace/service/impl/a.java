package com.ljs.springbootplace.service.impl;

import java.util.*;
import java.util.stream.Collectors;

public class a {
    public static void main(String[] args) {
        //list集合的遍历
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2);
        //使用stream流复制集合,将集合中值不为“4”的数据复制到新的集合中
        List<Integer> list_copy = null;
        list_copy = list.stream().filter(item -> (item != 4)).collect(Collectors.toList());
        System.out.println(list_copy);//[3, 5, 2]

        //map集合的遍历,将key值不为3的数据复制到新的集合中
        Map<String, String> map = new HashMap<>();
        map.put("1", "一");
        map.put("2", "二");
        map.put("3", "三");
        map.put("4", "四");

        Map<String, String> map_copy = new HashMap<>();
        map.keySet().stream().filter(i -> (!i.equals("3"))).forEach(k->map_copy.put(k,map.get(k)));
        map_copy.forEach((k,v)-> System.out.println(k+"-"+v));
        /*
            1-一
            2-二
            4-四
         */
    }
}