package com.liming.tanxin;

/**
 * @author ltf
 * @date 2021-09-09 10:49
 * 55. 跳跃游戏
 */
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }
}
