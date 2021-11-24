package com.liming.offer;

/**
 * @author ltf
 * @date 2021-02-18 15:02
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    res = nums[i];
                    flag = true;
                    break;
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
            if (flag) {
                break;
            }
        }
        return res;
    }
}
