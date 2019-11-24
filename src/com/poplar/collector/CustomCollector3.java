package com.poplar.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * Created BY poplar ON 2019/11/21
 * onClose(Runnable closeHandler);方法测试
 */
public class CustomCollector3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "hello", "world", "beautiful cat", "severn cat");
        NullPointerException nullPointerException = new NullPointerException("nullPointerException");
        try (Stream<String> stream = list.stream()) {
            stream.onClose(() -> {
                System.out.println("aaa");
                //throw nullPointerException;
                throw new NullPointerException("customException1");
            }).onClose(() -> {
                System.out.println("bbb");
                //throw nullPointerException;//不会压制
                throw new NullPointerException("customException1");//该异常会压制前面的异常
            }).forEach(System.out::println);
        }
    }
}
