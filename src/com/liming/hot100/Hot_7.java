package com.liming.hot100;

/**
 * @author ltf
 * @date 2022-02-01 19:10
 * 11. 盛最多水的容器
 */
public class Hot_7 {
    public int maxArea(int[] height) {
        int res = 0, left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (res < height[left] * (right - left)) {
                    res = height[left] * (right - left);
                }
                left++;
            } else {
                if (res < height[right] * (right - left)) {
                    res = height[right] * (right - left);
                }
                right--;
            }
        }
        return res;
    }
}
