package com.poplar.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created BY poplar ON 2019/11/21
 */
public class ComparatorTest1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "beautiful cat", "severn cat");
        list.sort(String::compareTo);
        System.out.println(list);
    }
}
