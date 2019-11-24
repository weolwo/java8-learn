package com.poplar.stream;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created BY poplar ON 2019/11/20
 */
public class StreamTest4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello world", "world", "hello world", "hello welcome", "welcome");
        //list.stream().filter(e -> e.length() == 5).findFirst().ifPresent(System.out::println);
        //去重flatMap()把几个数组合并到一个流里面
        list.stream().map(e -> e.split(" ")).flatMap(Arrays::stream).distinct().
                collect(Collectors.toCollection(LinkedHashSet::new)).forEach(System.out::println);
    }
}
