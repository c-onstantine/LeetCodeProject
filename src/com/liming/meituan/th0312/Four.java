package com.liming.meituan.th0312;

import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-03-12 17:14
 */
public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m + 1];
        int cur = 1;
        int res = 0;
        for(int i = 1; i <= m; i++){
            int tik = sc.nextInt();
            if(cur == tik){
                cur = i;
                res++;
            }
        }
        System.out.println(res);

    }
}
