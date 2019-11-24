package com.poplar.function;

import java.util.function.Function;

/**
 * BY poplar ON 2019/11/17
 * 函数式编程
 * 测试：compose()方法和andThen()方法
 */
public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 functionTest = new FunctionTest2();
        System.out.println(functionTest.computer1(2, value -> value * 3, value -> value * value));//12
        System.out.println(functionTest.computer2(2, value -> value * 3, value -> value * value));//36
    }

    public int computer1(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    public int computer2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }
}
