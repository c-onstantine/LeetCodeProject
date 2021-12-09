package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-09 19:53
 * 剑指 Offer II 012. 左右两边子数组的和相等
 */
public class Offer_II_012 {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (total - sum == sum - nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
