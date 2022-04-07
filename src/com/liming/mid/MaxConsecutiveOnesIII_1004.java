package com.liming.mid;

/**
 * @author ltf
 * @date 2022-04-07 20:51
 */
public class MaxConsecutiveOnesIII_1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int res = 0;
        int zeros = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
