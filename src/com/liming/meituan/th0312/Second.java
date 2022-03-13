package com.liming.meituan.th0312;

import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-03-12 16:19
 */
public class Second {
    private static int res=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }
        //dfs(arr,arr[0],1);
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0] == 1 ? 1 : 0;
        dp[0][1] = arr[0] == -1 ? 1 : 0;
        for(int i = 1; i < n; i++){
            if(arr[i] == 1){
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1];
            }else{
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        for (int[] d : dp) {
            res+=d[0];
        }
        System.out.println(res);
    }
    private static void dfs(int[] arr, int i, int startIndex){
        if(i > 0){
            res++;
        }
        if(startIndex >= arr.length){
            return;
        }
        for(int j = startIndex; j < arr.length; j++){
            dfs(arr,i*arr[j],j+1);
        }
    }
}
