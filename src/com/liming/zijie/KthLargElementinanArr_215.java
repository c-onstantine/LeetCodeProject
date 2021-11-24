package com.liming.zijie;

import java.util.Random;

/**
 * @author ltf
 * @date 2021-09-22 21:01
 * 215. 数组中的第K个最大元素
 */
public class KthLargElementinanArr_215 {
    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int index = part(nums, left, right);
            if (index < target) {
                left = index + 1;
            } else if (index > target) {
                right = index - 1;
            } else {
                return nums[index];
            }
        }
    }

    private int part(int[] nums, int left, int right) {
        if (right > left) {
            int index = left + 1 + random.nextInt(right - left);
            swap(nums, left, index);
        }
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
