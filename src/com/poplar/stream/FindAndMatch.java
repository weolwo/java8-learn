package com.poplar.stream;

import com.poplar.bean.Dish;
import com.poplar.enums.Type;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created BY poplar ON 2019/12/26
 * 查找和匹配
 */
public class FindAndMatch {
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

        if (menu.stream().anyMatch(s -> s.isVegetarian())) {
            System.out.println("this menu have somewhat Vegetarian friendly");
        }
        //看看菜品是否有利健康（即所有菜的热量都低于1000卡路里）：
        if (menu.stream().allMatch(s -> s.getCalories() < 1000)) {
            System.out.println("this menu have somewhat Vegetarian friendly");
        }

        //想 找到一道素食菜肴 findAny()的用法
        menu.stream().filter(s -> s.isVegetarian()).findAny().ifPresent(s -> System.out.println(s));

        //查找第一个元素
        // 找出第一个平方 能被3整除的数
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst().ifPresent(s -> System.out.println(s));

        //为什么会同时有findFirst和findAny呢？答案是并行。找到第一个元素 在并行上限制更多。如果你不关心返回的元素是哪个，请使用findAny，
        // 因为它在使用并行流 时限制较少。

    }
}
