package com.liming.tanxin;


/**
 * @author ltf
 * @date 2021-09-09 11:57
 * 45. 跳跃游戏 II
 */
public class JumpGameII_45 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int ans = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            next = Math.max(i + nums[i], next);
            if (i == cur) {
                if (cur != nums.length - 1) {
                    ans++;
                    cur = next;
                    if (next >= nums.length - 1) break;
                }else break;
            }
        }
        return ans;
    }
}
