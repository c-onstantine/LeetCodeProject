package com.liming.dp;

/**
 * @author ltf
 * @date 2021-08-14 11:44
 * 518. 零钱兑换 II
 */
public class CoinChange2_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
