package com.liming.offerspecial;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-12-17 20:01
 */
public class Offer_II_038 {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) return new int[0];
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[stack.peekFirst()] >= temperatures[i]) {
                stack.offerFirst(i);
            } else if (!stack.isEmpty() && temperatures[stack.peekFirst()] < temperatures[i]) {
                while (!stack.isEmpty() && temperatures[stack.peekFirst()] < temperatures[i]) {
                    res[stack.peekFirst()] = i - stack.pollFirst();
                }
                stack.offerFirst(i);
            }
        }
        return res;
    }
}
