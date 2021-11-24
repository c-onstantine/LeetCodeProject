package com.liming.test;

import java.util.function.Predicate;

/**
 * @author ltf
 * @date 2021-01-13 9:13
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        //Person p1 =new Person(1,"a",new Dog());
        //Person p2 =p1;
        //System.out.println(p1);
        //System.out.println(p2);
        //System.out.println("------------------");
        //Person p3 = (Person) p1.clone();
        //System.out.println(p3);
        //System.out.println("------------------");
        //System.out.println(p1.getName() == p3.getName());
        //System.out.println("------------------");
        //
        //System.out.println(p2.getName());
        //System.out.println(p3.getName());
        //System.out.println(p3.getDog());
        //System.out.println(p1.getDog());

        //测试 函数式接口
        Predicate<String> p = a->a.startsWith("l");
        boolean test = p.and(a -> a.endsWith("f")).test("ltfz");
        System.out.println(test);
    }
}
