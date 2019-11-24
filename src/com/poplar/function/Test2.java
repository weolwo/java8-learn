package com.poplar.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BY poplar ON 2019/11/17
 * 函数式接口的三种实例化方式
 * Note that instances of functional interfaces can be created with
 * lambda expressions, method references, or constructor references.
 */
public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //1,lambda expressions
        list.forEach((i) -> {
            System.out.println(i * 2);
        });

        //2, method references
        list.forEach(System.out::print);
        //3,TODO
    }
}
