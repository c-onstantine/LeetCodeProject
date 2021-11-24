package com.liming.mietun;

/**
 * @author ltf
 * @date 2021-10-27 20:26
 * 704. 二分查找
 */
public class BinarySearch_704 {
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
