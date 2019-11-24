package com.poplar.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created BY poplar ON 2019/11/20
 */
public class StreamTest2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //累加
        System.out.println(list.stream().map(i -> i * 2).reduce(0, Integer::sum));
    }
}
