package com.poplar.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created BY poplar ON 2019/11/20
 */
public class StreamTest5 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("猫花", "七猫", "二猫", "美猫", "甜猫");
        //使list1和list2组成一个笛卡儿积
        list1.stream().flatMap(element1 -> list2.stream().map(element2 -> element1 + " " + element2))
                .collect(Collectors.toCollection(LinkedList::new)).forEach(System.out::println);
    }
}
