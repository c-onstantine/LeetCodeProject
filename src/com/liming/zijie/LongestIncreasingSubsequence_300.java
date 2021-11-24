package com.liming.zijie;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-10-09 21:46
 * 300. 最长递增子序列
 */
public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        if (len < 2) {
            return len;
        }
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
