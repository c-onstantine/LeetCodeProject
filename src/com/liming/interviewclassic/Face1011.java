package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-05-20 21:07
 */
public class Face1011 {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if ((i & 1) == 1 ? nums[i] < nums[i - 1] : nums[i] > nums[i - 1]) {
                swap(nums, i, i - 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
