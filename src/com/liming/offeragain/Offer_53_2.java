package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-08 16:24
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class Offer_53_2 {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == mid) i = mid + 1;
            else j = mid - 1;
        }
        return i;
    }
}
