package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-28 20:44
 * 剑指 Offer II 068. 查找插入位置  二分
 */
public class Offer_II_068 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }
}
