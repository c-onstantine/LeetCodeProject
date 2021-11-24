package com.liming.dp;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-08-12 16:53
 * 1049. 最后一块石头的重量 II
 */
public class LastStoneWeight2_1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int[] dp = new int[sum];
        int target = sum / 2;
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}
