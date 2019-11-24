package com.poplar.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created BY poplar ON 2019/11/20
 */
public class StreamTest1 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2");
        Stream<List<String>> listStream = Stream.of(Arrays.asList("hello", "world"));
        Stream<String> arrStream = Stream.of(new String[]{"七猫", "二猫"});
    }
}
