package com.liming.zijie;

/**
 * @author ltf
 * @date 2021-09-30 16:46
 * 31. 下一个排列
 */
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2, j = len - 1, k = len - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        if (i >= 0) {
            while (nums[i] >= nums[k]) {
                k--;
            }
            swap(nums, i, k);
        }
        for (int i1 = j, j1 = len - 1; i1 < j1; i1++, j1--) {
            swap(nums, i1, j1);
        }
    }

    private void swap(int[] nums, int x, int y) {
        nums[x] ^= nums[y];
        nums[y] ^= nums[x];
        nums[x] ^= nums[y];
    }
}
