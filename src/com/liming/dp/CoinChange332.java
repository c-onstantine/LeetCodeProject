package com.liming.dp;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2020-12-23 21:10
 */
public class CoinChange332 {
    public int coinChange(int[] coins, int amount) {
        int [] dp=new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if(i-coin<0) continue;
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return dp[amount]==amount+1 ? -1:dp[amount];
    }
}
