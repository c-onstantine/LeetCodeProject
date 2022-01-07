package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2022-01-07 18:40
 */
public class Offer_II_098 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++){
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}
