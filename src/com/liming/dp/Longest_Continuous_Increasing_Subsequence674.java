package com.liming.dp;

/**
 * @author ltf
 * @date 2021-01-03 13:50
 */
public class Longest_Continuous_Increasing_Subsequence674 {
    public int findLengthOfLCIS(int[] nums) {
        int dp=1;
        int res=0;
        if(nums.length==1)return dp;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                dp+=1;
            }else{
                dp=1;
            }
            res=Math.max(res, dp);
        }
        return res;
    }
}
