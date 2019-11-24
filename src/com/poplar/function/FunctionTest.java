package com.poplar.function;

        import java.util.function.Function;

/**
 * BY poplar ON 2019/11/17
 * 函数式编程
 */
public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        //函数式编程——>方法中可以传入行为--->高阶函数
        System.out.println(functionTest.computer(2, value -> value + 2));
        System.out.println(functionTest.convert(2, value -> String.valueOf(value + "Hello")));
    }

    /**
     * @param a        输入的参数值
     * @param function 传入的函数
     * @return 返回值
     */
    public int computer(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    /**
     * @param a        输入的参数值
     * @param function Integer函数的输入类型 String函数的返回类型
     * @return 返回值
     */
    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

    //传统方法,事先写好
    public int method1(int a) {
        return a + 2;
    }
}
