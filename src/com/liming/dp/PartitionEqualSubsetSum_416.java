package com.liming.dp;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-08-12 12:02
 * 416. 分割等和子集
 */
public class PartitionEqualSubsetSum_416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int[] dp = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        if (dp[target] == target) return true;
        return false;
    }
}
