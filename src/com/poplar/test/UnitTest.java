package com.poplar.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * by poplar created on 2020/1/10
 * 参考来链接：这个是我工作中遇到后个人工作体会分享 - Piao飘的文章 - 知乎
 * https://zhuanlan.zhihu.com/p/101555662
 */
public class UnitTest {

    @Test
    public void test() {
        List<Double> list = Arrays.asList(4.3, 4.8, 2.3);
        double value = list.stream().peek(e -> System.out.println("from stream " + e)).filter(Objects::nonNull).map(String::valueOf).peek(e -> System.out.println("from String " + e)).map(BigDecimal::new)
                .peek(e -> System.out.println("from map " + e)).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
        System.out.println(value);
    }

/*
from stream 4.3
from String 4.3
from map 4.3
from stream 4.8
from String 4.8
from map 4.8
from stream 2.3
from String 2.3
from map 2.3
11.4*/
}

