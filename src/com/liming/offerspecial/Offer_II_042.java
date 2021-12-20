package com.liming.offerspecial;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-12-20 20:56
 */
public class Offer_II_042 {
    private Deque<Integer> deque;

    public Offer_II_042() {
        deque = new ArrayDeque<>();
    }

    public int ping(int t) {
        deque.offer(t);
        while (deque.peek() < t - 3000) {
            deque.poll();
        }
        return deque.size();
    }
}
