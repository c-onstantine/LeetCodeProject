package com.liming.ali.bishi0325;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-03-25 9:52
 */
public class Test2 {
    private static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            Integer[] arr = new Integer[5];
            for (int i = 0; i < 5; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr, (a, b) -> b.compareTo(a));
            while (arr[3] > 0){
                res += arr[3];
                for (int i = 0; i < 4; i++) {
                    arr[i] = arr[i] - arr[3];
                }
                Arrays.sort(arr, (a, b) -> b.compareTo(a));
            }
            System.out.println(res);
        }
    }

}
