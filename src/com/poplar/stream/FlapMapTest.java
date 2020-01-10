package com.poplar.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created BY poplar ON 2019/12/26
 * 流的扁平化
 * flatMap把各个数组并不是分别映射成一个流，而是映射成流的内容
 */
public class FlapMapTest {
    public static void main(String[] args) {
        //给定单词列表 ["Hello","World"]，你想要返回列表["H","e","l", "o","W","r","d"]
        List<String> list = Arrays.asList("hello", "world");
        List<String> stringList = list.stream().map(e -> e.split("")).flatMap(s -> Arrays.stream(s)).distinct().collect(Collectors.toList());
        System.out.println(stringList);
    }
}
