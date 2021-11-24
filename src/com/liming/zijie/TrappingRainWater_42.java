package com.liming.zijie;

/**
 * @author ltf
 * @date 2021-09-28 11:47
 */
public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int len = height.length;
        int[] maxleft = new int[len];
        int[] maxright = new int[len];
        for (int i = 1; i < len - 1; i++) {
            maxleft[i] = Math.max(maxleft[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            maxright[i] = Math.max(maxleft[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(maxleft[i], maxright[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }


}
