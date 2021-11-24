package com.liming.dp;

/**
 * @author ltf
 * @date 2021-08-10 16:43
 * 70. 爬楼梯
 */
public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        if (n <= 1) return n;
        int sum = 1;
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n; i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;
    }
}
