package com.liming.dp;

/**
 * @author ltf
 * @date 2021-08-11 15:07
 * 343. 整数拆分
 */
public class IntegerBreak_343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
