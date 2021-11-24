package com.liming.dp;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-01-03 11:43
 */
public class Number_of_Longest_Increasing_Subsequence673 {
    public int findNumberOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        int [] state =new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(state, 1);
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[i]==dp[j]+1){
                        state[i]+=state[j];
                    }else if(dp[j]>=dp[i]){
                        dp[i]=dp[j]+1;
                        state[i]=state[j];
                    }

                }

            }

        }

        for (int i = 0; i < dp.length; i++) {
            res=Math.max(res, dp[i]);
        }
        int count=0;
        for (int i = 0; i < dp.length; i++) {
           if(dp[i]==res){
               count+=state[i];
           }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] res={1,3,5,4,7};
        new Number_of_Longest_Increasing_Subsequence673().findNumberOfLIS(res);
    }
}
