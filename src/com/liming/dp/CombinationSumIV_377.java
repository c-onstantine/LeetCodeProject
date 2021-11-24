package com.liming.dp;

/**
 * @author ltf
 * @date 2021-08-14 15:20
 * 377. 组合总和 Ⅳ
 */
public class CombinationSumIV_377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
