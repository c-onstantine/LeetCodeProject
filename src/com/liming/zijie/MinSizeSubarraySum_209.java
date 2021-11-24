package com.liming.zijie;

/**
 * @author ltf
 * @date 2021-09-22 20:12
 */
public class MinSizeSubarraySum_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int cur = 0;
        int max = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < nums.length) {
            cur += nums[right];
            while (cur >= target) {
                max = Math.min(max, right - left + 1);
                cur -= nums[left];
                left++;
            }
            right++;
        }
        return max == Integer.MAX_VALUE ? 0 : max;
    }
}
