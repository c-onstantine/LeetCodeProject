package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-08 16:06
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class Offer_53 {
    public int search(int[] nums, int target) {
        // 都是整数 所以求出小于target 1 的 右边界 相减即可。
        return helper(nums, target) - helper(nums, target - 1);
    }

    private int helper(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int mid;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (nums[mid] <= target) i = mid + 1;
            else j = mid - 1;
        }
        return j;
    }
}
