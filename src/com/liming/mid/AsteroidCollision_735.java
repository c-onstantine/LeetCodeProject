package com.liming.mid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2022-04-06 20:38
 */
public class AsteroidCollision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int ast : asteroids) {
            if (ast < 0) {
                while (!deque.isEmpty() && deque.peekFirst() > 0 && deque.peekFirst() < -ast) {
                    deque.pollFirst();
                }
                if (deque.isEmpty() || deque.peekFirst() < 0) {
                    deque.offerFirst(ast);
                } else if (deque.peekFirst() == -ast) {
                    deque.pollFirst();
                }
            } else {
                deque.offerFirst(ast);
            }

        }
        int[] res = new int[deque.size()];
        int index = 0;
        while (!deque.isEmpty()) {
            res[index++] = deque.pollLast();
        }
        return res;
    }
}
