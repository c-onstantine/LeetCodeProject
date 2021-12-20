package com.liming.offerspecial;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-12-20 20:45
 */
public class Offer_II_041 {
    private int size;
    private Deque<Integer> queue;
    private int sum;

    /**
     * Initialize your data structure here.
     */
    public Offer_II_041(int size) {
        this.size = size;
        sum = 0;
        queue = new ArrayDeque<>();
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        sum += val;
        queue.offer(val);
        return (double) sum / queue.size();
    }
}
