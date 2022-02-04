package com.liming.hot100;

/**
 * @author ltf
 * @date 2022-02-04 13:10
 * 42. 接雨水
 */
public class Hot_11 {
    public int trap(int[] height) {
        int res = 0;
        int maxLeft = 0;
        int[] maxRight = new int[height.length];
        for (int i = height.length - 2; i > 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            int min = maxLeft > maxRight[i] ? maxRight[i] : maxLeft;
            if (min > height[i]) {
                res += (min - height[i]);
            }
        }
        return res;
    }
}
