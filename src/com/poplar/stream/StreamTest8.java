package com.poplar.stream;

import com.poplar.bean.Dish;
import com.poplar.enums.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created BY poplar ON 2019/12/26
 * 总而言之，流的使用一般包括三件事：
 * 一个数据源（如集合）来执行一个查询；
 * 一个中间操作链，形成一条流的流水线；
 * 一个终端操作，执行流水线，并能生成结果。
 */
public class StreamTest8 {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("french fries", true, 200, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("salmon", false, 450, Type.FISH));

        //测试流的执行过程
        List<String> list = menu.stream().filter(a -> {
            System.out.println("filter " + a.getName());
            return a.getCalories() >= 300;
        }).map(a -> {
            System.out.println("map" + a.getName());
            return a.getName();
        }).limit(3).collect(Collectors.toList());
        //找出三个高热量蔡的名字
        System.out.println(list);

        //输出：
        /*filter pork
        mappork
        filter beef
        mapbeef
        filter french fries
        filter rice
        maprice*/

        //创建一张素食菜单
        List<String> vegetarianMenu = menu.stream().filter(a -> a.isVegetarian()).map(s -> s.getName() + ": " + s.getCalories()).collect(Collectors.toList());
        System.out.println(vegetarianMenu);
    }
}
