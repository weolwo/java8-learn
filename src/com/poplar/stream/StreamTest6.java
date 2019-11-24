package com.poplar.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created BY poplar ON 2019/11/21
 * 分组和分区
 */
public class StreamTest6 {
    public static void main(String[] args) {
        Student student1 = new Student("七猫", 18, 90);
        Student student2 = new Student("2猫", 19, 90);
        Student student3 = new Student("七猫", 20, 70);
        Student student4 = new Student("5猫", 17, 80);
        List<Student> list = Arrays.asList(student1, student2, student3, student4);
        //按照名字进行分组
//        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
//        System.out.println(map);
        //分区,分区其实就是分组的一种特殊情况，只有false和true两种情况
        Map<Boolean, List<Student>> booleanListMap = list.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
        System.out.println(booleanListMap);
    }
}

class Student {

    private String name;

    private int age;

    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
}