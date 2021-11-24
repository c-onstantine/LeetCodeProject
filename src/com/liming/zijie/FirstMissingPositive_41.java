package com.liming.zijie;

/**
 * @author ltf
 * @date 2021-10-14 19:30
 * 41. 缺失的第一个正数
 * 原地哈希
 */
public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
