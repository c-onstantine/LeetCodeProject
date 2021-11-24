package com.liming.dp;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-08-15 11:04
 * 279. 完全平方数
 */
public class PerfectSquares_279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
