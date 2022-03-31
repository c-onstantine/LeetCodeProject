package com.liming.huawei.test;

import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-03-23 15:56
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int sum = 0;
        for (String str : strs) {
            sum += str.length();
        }
        System.out.printf("%.2f", (double)sum / strs.length);
    }
}
