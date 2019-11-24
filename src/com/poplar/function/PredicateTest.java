package com.poplar.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * BY poplar ON 2019/11/17
 * 函数式接口Predicate
 */
public class PredicateTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateTest test = new PredicateTest();
        test.conditionalFilter(list, element -> element % 2 == 0);
        System.out.println("--------------------------------");
        test.findFallOdds(list);

    }

    //使用函数式接口高度抽象化的方法,其实也相当于一种策略模式
    public void conditionalFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer element : list) {
            if (predicate.test(element)) {
                System.out.println(element);
            }
        }
    }

    //面向对象的具体化的方法
    public void findFallOdds(List<Integer> list) {
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                System.out.println(integer);
            }
        }
    }
}
