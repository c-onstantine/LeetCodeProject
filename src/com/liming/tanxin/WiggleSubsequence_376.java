package com.liming.tanxin;

/**
 * @author ltf
 * @date 2021-09-08 20:18
 */
public class WiggleSubsequence_376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int curdiff = 0;
        int prediff = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            curdiff = nums[i] - nums[i - 1];
            if ((curdiff < 0 && prediff >= 0) || (curdiff > 0 && prediff <= 0)) {
                res++;
                prediff = curdiff;
            }
        }
        return res;
    }
}
