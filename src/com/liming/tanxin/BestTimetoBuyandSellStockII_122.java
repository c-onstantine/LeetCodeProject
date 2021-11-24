package com.liming.tanxin;

/**
 * @author ltf
 * @date 2021-09-09 10:38
 * 122. 买卖股票的最佳时机 II
 */
public class BestTimetoBuyandSellStockII_122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
