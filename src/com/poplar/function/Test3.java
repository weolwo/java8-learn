package com.poplar.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created BY poplar ON 2019/12/25
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world");
        Predicate<String> p = list::add;

       Consumer<String> b = list::add;
        //错误：Lambda表达式引用的局 部变量必须是最终的（final） 或事实上最终的
        int portNumber = 1337;
        //Runnable r = () -> System.out.println(portNumber);
        portNumber = 31337;

        Supplier supplier = ArrayList::new;
        List l = (List) supplier.get();
        l.add("hello");
    }
}
