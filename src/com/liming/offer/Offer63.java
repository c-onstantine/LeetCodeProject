package com.liming.offer;

/**
 * @author ltf
 * @date 2021-04-07 14:09
 */
public class Offer63 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}
