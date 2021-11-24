package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-17 21:34
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class Offer_21 {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp = 0;
        while (i < j) {
            if ((nums[i] & 1) == 1) {
                i++;
                continue;
            }
            if ((nums[j] & 1) == 0) {
                j--;
                continue;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
