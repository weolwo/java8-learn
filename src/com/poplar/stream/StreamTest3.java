package com.poplar.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created BY poplar ON 2019/11/20
 * Stream操作及注意
 */
public class StreamTest3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        Stream<Integer> stream = Stream.iterate(1, e -> e + 2).limit(6);
        //Integer result1 = stream.filter(e -> e > 2).map(f -> f * 2).skip(2).limit(2).reduce(0, Integer::sum);
        //int result2 = stream.filter(e -> e > 2).mapToInt(f -> f * 2).skip(2).limit(2).sum();
        //int result2 = stream.filter(e -> e > 2).mapToInt(f -> f * 2).skip(2).limit(2).sum();
        //max()会返回一个OptionalInt对象，而从该对象中获取值时最好使用ifPresent()方法
        //stream.filter(e -> e > 2).mapToInt(f -> f * 2).skip(2).limit(2).max().ifPresent(System.out::println);
        //System.out.println("result1: "+result1);
        //System.out.println("result2: " + result2);
        //JDK为我们提供的一次进行多种操作
        IntSummaryStatistics summaryStatistics = stream.filter(e -> e > 2).mapToInt(e -> e * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getSum());
    }
}
