package com.poplar.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created BY poplar ON 2019/11/23
 * 流的操作是类似于流水线的运作模式的，对于进入流中的每一个元素都会执行一遍相同的操作
 */
public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "hello", "world", "beautiful cat", "severn cat");
        //在没有中间操作和当前操作的流为串行流时或调用Head中的实现
       // list.stream().forEach(System.out::println);
        //而如果有中间操作且为并行流会执行ReferencePipeline中的方法
        //list.stream().map(String::toUpperCase).forEach(System.out::println);

        //Iterable接口中的默认实现方法
        //list.forEach(System.out::println);

        list.stream().sorted(String::compareTo).forEach(System.out::println);
    }
}
