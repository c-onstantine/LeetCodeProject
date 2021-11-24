package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-25 20:33
 */
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if (nums == null || length < 2) return new int[0];
        int i = 0, j = length - 1;
        int tmp = 0;
        while (i < j) {
            tmp = nums[i] + nums[j];
            if (tmp > target) j--;
            else if (tmp < target) i++;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }
}
