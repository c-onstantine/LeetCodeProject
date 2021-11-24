package com.liming.mid;

/**
 * @author ltf
 * @date 2021-05-14 12:54
 */
public class Find_minRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
