package com.liming.dp;

/**
 * @author ltf
 * @date 2021-01-26 17:58
 */
public class Sell_Stock121 {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min=prices[i];
            }else if(prices[i]-min>max){
                max=prices[i]-min;
            }
        }
        return max;
    }
}
