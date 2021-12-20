package com.liming.offerspecial;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-12-20 20:05
 * 困难  剑指 Offer II 039. 直方图最大矩形面积
 */
public class Offer_II_039 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(-1);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peekFirst() != -1 && heights[stack.peekFirst()] >= heights[i]) {
                int height = heights[stack.pollFirst()];
                int width = i - stack.peekFirst() - 1;
                res = Math.max(res, height * width);
            }
            stack.offerFirst(i);
        }
        while (stack.peekFirst() != -1) {
            int height = heights[stack.pollFirst()];
            int width = heights.length - stack.peekFirst() - 1;
            res = Math.max(res, height * width);
        }
        return res;
    }
}
