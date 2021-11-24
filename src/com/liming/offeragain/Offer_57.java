package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-17 21:45
 * 剑指 Offer 57. 和为s的两个数字
 */
public class Offer_57 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1, res = 0;
        while (i < j) {
            res = nums[i] + nums[j];
            if (res < target) {
                i++;
            } else if (res > target) {
                j--;
            } else if (res == target) {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }
}
