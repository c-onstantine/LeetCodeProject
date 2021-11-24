package com.liming.dp;

/**
 * @author ltf
 * @date 2021-01-27 8:48
 */
public class Sell_Stock_II122 {
    public int maxProfit(int[] prices) {
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            int tmp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, tmp - prices[i]);
        }
        return dp0;
    }
}
