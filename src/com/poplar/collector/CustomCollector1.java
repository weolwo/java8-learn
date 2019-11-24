package com.poplar.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created BY poplar ON 2019/11/21
 * 自定义实现Collector接口
 */
public class CustomCollector1<T> implements Collector<T, Set<T>, Set<T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked");
        //直接返回一个HashSet容器
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked");
        //此处不能直接返回具体实现类，因为supplier中已经指定了容器具体类型
        return Set::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked");
        //接收2个参数返回一个
        return (p1, p2) -> {
            p1.addAll(p2);
            return p1;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoked");
        //return Function.identity();
        return t -> t;
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "hello", "world", "beautiful cat", "severn cat");
        Set<String> set = list.stream().collect(new CustomCollector1<>());
        System.out.println(set);
        /*
        执行结果：
        supplier invoked
         accumulator invoked
         combiner invoked
         characteristics invoked
         characteristics invoked
         [world, severn cat, hello, beautiful cat]*/
    }
}
