package com.liming.offerspecial;

import java.util.List;

/**
 * @author ltf
 * @date 2022-01-08 13:44
 */
public class Offer_II_100 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        //初始化
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        int res = dp[triangle.size() - 1][0];
        for (int i = 1; i < triangle.size(); i++) {
            res = Math.min(res, dp[triangle.size() - 1][i]);
        }
        return res;
    }
}
