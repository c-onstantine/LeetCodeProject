package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-08 15:20
 * 剑指 Offer 03. 数组中重复的数字
 */
public class Offer_03 {
    public int findRepeatNumber(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
