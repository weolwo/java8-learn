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
public class CustomCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {

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
        //return Set::add;
        return (set, item) -> {
            //多线程情况下此处会抛出ConcurrentModificationException，读写
            System.out.println(set + " : " + Thread.currentThread().getName());
            set.add(item);
        };
    }

    //此方法如果是单线程的话，是不会被调用的
    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked");
        //接收2个参数返回一个
        return (p1, p2) -> {
            System.out.println("p1 " + p1);
            System.out.println("p2 " + p2);
            p1.addAll(p2);
            return p1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked");
        return set -> {
            Map<T, T> map = new HashMap<>();
            set.forEach(e -> map.put(e, e));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked");
        //此处不能使用IDENTITY_FINISH,因为返回类型和输入类型不一样
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED, Characteristics.CONCURRENT));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            List<String> list = Arrays.asList("hello", "hello", "world", "beautiful cat", "severn cat");
            Set<String> set = new HashSet<>(list);
            Map<String, String> map = set.stream().collect(new CustomCollector2<>());
            System.out.println(map);

        }
    }
}
