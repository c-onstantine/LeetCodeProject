package com.liming.dp;

/**
 * @author ltf
 * @date 2021-08-10 17:29
 */
public class inCostClimbingStairs_746 {
    public int minCostClimbingStairs(int[] cost) {
        int dp1 = cost[0];
        int dp2 = cost[1];
        int sum = 0;
        for (int i = 2; i < cost.length; i++) {
            sum = Math.min(dp1, dp2) + cost[i];
            dp1 = dp2;
            dp2 = sum;
        }
        return Math.min(dp1, dp2);
    }
}
