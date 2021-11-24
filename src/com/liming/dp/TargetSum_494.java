package com.liming.dp;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-08-13 10:25
 * 494. 目标和
 */
public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target > sum || (target + sum) % 2 == 1) return 0;
        int dpsize = (target + sum) / 2;
        int[] dp = new int[dpsize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dpsize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[dpsize];
    }
}
