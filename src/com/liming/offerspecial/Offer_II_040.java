package com.liming.offerspecial;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-12-20 20:23
 */
public class Offer_II_040 {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) return 0;
        int res = 0;
        int[] heights = new int[matrix[0].length()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length(); j++) {
                if (matrix[i].charAt(j) == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += matrix[i].charAt(j) - '0';
                }
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }

    private int largestRectangleArea(int[] heights) {
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
