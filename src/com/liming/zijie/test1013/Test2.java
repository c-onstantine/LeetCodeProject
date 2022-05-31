package com.liming.zijie.test1013;

import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-04-10 10:13
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (arr.length == 1) {
            System.out.println("TRUE");
            return;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + arr[i]);
            if (coverRange >= arr.length - 1) {
                System.out.println("TRUE");
                return;
            }
        }
        System.out.println("FALSE");
    }
}
