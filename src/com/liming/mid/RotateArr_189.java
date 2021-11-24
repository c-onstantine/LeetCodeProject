package com.liming.mid;

/**
 * @author ltf
 * @date 2021-05-13 21:13
 */
public class RotateArr_189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
            start += 1;
            end -= 1;
        }
    }
}
