package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-19 17:16
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (cur <= 0) cur = num;
            else cur += num;
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }
}
