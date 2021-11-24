package com.liming.dp;

/**
 * @author ltf
 * @date 2021-01-03 11:32
 */
public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        int heap=0;
        int [] dp = new int[nums.length];
        int left=0;
        int right=heap;
        for (int i = 0; i < nums.length; i++) {
            left=0;
            right=heap;
            while(left<right){
                int mid=(left+right)/2;
                if(dp[mid]>nums[i]){
                    right=mid;
                }else if(dp[mid]<nums[i]){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            if(left==heap) heap++;
            dp[left]=nums[i];
        }
        return heap;
    }
}
