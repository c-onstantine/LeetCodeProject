package com.liming.easy;

/**
 * @author ltf
 * @date 2020-10-19 14:04
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int [] res=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    break;
                }
            }
        }
        return res;
    }

}
