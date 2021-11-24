package com.liming.dp;

/**
 * @author ltf
 * @date 2021-08-16 14:40
 * 121. 买卖股票的最佳时机
 */
public class BestTimetoBuyandSellStock_121 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], -prices[i]);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0] + prices[i]);
        }
        return dp[(prices.length - 1) % 2][1];
    }
}
