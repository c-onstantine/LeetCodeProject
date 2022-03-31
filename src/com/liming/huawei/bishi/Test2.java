//package com.liming.huawei.bishi;
//
//import java.util.Scanner;
//
///**
// * @author ltf
// * @date 2022-03-23 20:00
// */
//public class Test2 {
//    private static int[] dp;
//    private static int n;
//    private static int[] magic;
//
//    public static void main(String[] args) {
//        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        magic = new int[n + 1];
//        dp = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            dp[i] = Integer.MAX_VALUE;
//            magic[i] = sc.nextInt();
//        }
//        getTest(1, 0);
//        if (dp[n] == Integer.MAX_VALUE) {
//            System.out.println(-1);
//        } else {
//            System.out.println(dp[n]);
//        }
//    }
//
//    private static void getTest(int index, int step) {
//        if (index == n) {
//            dp[n] = Math.min(dp[n], step);
//            return;
//        }
//        if (step >= dp[index]) {
//            return;
//        } else {
//            dp[index] = step;
//        }
//        for (int i = index + 1; i <= n && i <= magic[index] + index; i++) {
//            getTest(i, step + 1);
//        }
//    }
//}
//
//
//    private static int[] dp;
//    private static int n;
//    private static int[] magic;
//    private static int k;
//    public static void main(String[] args) {
//        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//        Scanner sc = new Scanner(System.in);
//        n =sc.nextInt();
//        magic = new int[n + 1];
//        dp = new int[n + 1];
//        for(int i = 1; i<= n; i++){
//            dp[i] = Integer.MAX_VALUE;
//            magic[i] = sc.nextInt();
//        }
//        k = sc.nextInt();
//        getTest(1,0);
//        if(dp[n] == Integer.MAX_VALUE){
//            System.out.println(-1);
//        }else{
//            System.out.println(dp[n]);
//        }
//    }
//    private static void getTest(int index,int step){
//        if(step > dp[n]){
//            return;
//        }
//        if(step > k){
//            return;
//        }
//        if(index == n){
//            dp[n] = Math.min(dp[n],step);
//            return;
//        }
//        if(step >= dp[index]){
//            return;
//        }else{
//            dp[index] = step;
//        }
//        for(int i = index + 1; i <= n && i <= magic[index] + index; i++){
//            getTest(i,step + 1);
//        }
//    }