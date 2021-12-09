package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-08 20:19
 */
public class Offer_II_009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int res = 1;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            res *= nums[right];
            while (left <= right && res >= k) {
                res /= nums[left++];
            }
            if (left <= right) {
                ans += right - left + 1;
            }
        }
        return ans;
    }
}




