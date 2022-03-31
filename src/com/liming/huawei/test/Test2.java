package com.liming.huawei.test;

import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-03-23 16:00
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        System.out.println(str.replaceAll("a", "A").replaceAll("e", "E")
                .replaceAll("i", "I")
                .replaceAll("o", "O")
                .replaceAll("u", "U"));
    }
}
