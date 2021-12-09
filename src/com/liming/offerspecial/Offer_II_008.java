package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-08 20:05
 */
public class Offer_II_008 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left++];
            }
        }
        return min > nums.length ? 0 : min;
    }
}
