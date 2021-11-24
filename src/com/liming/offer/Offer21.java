package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-03 14:25
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[r] % 2 == 0) r--;
            while (l < r && nums[l] % 2 != 0) l++;
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        return nums;
    }
}
