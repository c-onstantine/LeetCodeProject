package com.liming.dp;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-01-28 15:59
 */
public class Sell_Stock_IV188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        k = Math.min(n / 2, k);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }
}
