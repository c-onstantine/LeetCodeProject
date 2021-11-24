package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-13 10:04
 */
public class Offer_63 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}
