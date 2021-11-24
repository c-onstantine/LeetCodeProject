package com.liming.mid;

/**
 * @author ltf
 * @date 2021-05-17 20:29
 * hard
 */
public class Find_MinRotatedSortedArray_154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right -= 1;
            }
        }
        return nums[left];
    }
}
