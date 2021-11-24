package com.liming.zijie;

/**
 * @author ltf
 * @date 2021-10-10 16:31
 * 53. 最大子序和 动态规划
 */
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
