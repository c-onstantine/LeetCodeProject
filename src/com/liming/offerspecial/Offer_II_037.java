package com.liming.offerspecial;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-12-17 16:32
 */
public class Offer_II_037 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        int p = 0;
        while (p < asteroids.length) {
            if (stack.isEmpty() || stack.peekFirst() < 0 || asteroids[p] > 0) {
                stack.offerFirst(asteroids[p]);
            } else if (stack.peekFirst() <= -asteroids[p]) {
                if (stack.pollFirst() < -asteroids[p]) {
                    continue;
                }
            }
            p++;
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pollFirst();
        }
        return res;
    }
}
