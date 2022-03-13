package com.liming.microsoft;

/**
 * @author ltf
 * @date 2022-03-06 11:27
 * 334. 递增的三元子序列
 */
public class IncreasingTripletSubseq_334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int[] leftdp = new int[nums.length];
        leftdp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftdp[i] = Math.min(leftdp[i - 1], nums[i]);
        }
        int[] rightdp = new int[nums.length];
        rightdp[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightdp[i] = Math.max(rightdp[i + 1], nums[i]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > leftdp[i - 1] && nums[i] < rightdp[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
