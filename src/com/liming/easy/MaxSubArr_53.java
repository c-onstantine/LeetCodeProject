package com.liming.easy;

/**
 * @author ltf
 * @date 2021-06-30 19:48
 */
public class MaxSubArr_53 {
    public int maxSubArray(int[] nums) {
        int dp_i = nums[0];
        int max = dp_i;
        for (int i = 1; i < nums.length; i++) {
            if (dp_i > 0) {
                dp_i += nums[i];
            } else {
                dp_i = nums[i];
            }
            if (max < dp_i) {
                max = dp_i;
            }
        }
        return max;
    }
}
