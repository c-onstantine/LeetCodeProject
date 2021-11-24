package com.liming.ali;

/**
 * @author ltf
 * @date 2021-11-15 20:52
 * 121. 买卖股票的最佳时机
 */
public class BestTimetoBuyandSellStock_121 {
    public int maxProfit(int[] prices) {
        int res = 0, pre = 0, tmp = 0;
        for (int i = 1; i < prices.length; i++) {
            tmp = prices[i] - prices[i - 1]; // 两天差值
            pre = Math.max(pre + tmp, 0); // i-1天卖出
            res = Math.max(res, pre);
        }
        return res;
    }
}
