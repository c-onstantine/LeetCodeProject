package com.liming.dp;

/**
 * @author ltf
 * @date 2021-08-16 17:57
 */
public class MaximumLengthofRepeatedSubarray_718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                if (dp[j] > res) res = dp[j];
            }
        }
        return res;
    }
}
