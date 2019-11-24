package com.poplar.function;

/**
 * BY poplar ON 2019/11/17
 */
@FunctionalInterface
interface MyInterFace {

    void test();
    /*  If an interface declares an abstract method overriding one of the public methods of java.lang.Object,
      that also does not count toward the interface's abstract method count since any implementation of the interface
      will have an implementation from java.lang.Object or elsewhere.*/
    String toString();
}

public class Test1 {

    public void testFunctionalInterface(MyInterFace interFace) {
        interFace.test();
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.testFunctionalInterface(() -> System.out.println("implement of MyInterFace1"));
        MyInterFace myInterFace = () -> System.out.println("implement of MyInterFace2");
        myInterFace.test();
        System.out.println(myInterFace.getClass());                    //Test1$$Lambda$2/1747585824
        System.out.println(myInterFace.getClass().getSuperclass());    //java.lang.Object
        System.out.println(myInterFace.getClass().getInterfaces()[0]);  //MyInterFace
    }
}