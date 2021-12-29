package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-28 21:25
 */
public class Offer_II_070 {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length - 1;
        int left = 0, right = len, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid < len && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (mid > 0 && nums[mid - 1] == nums[mid]) {
                if (mid % 2 == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return -1;
    }
}
