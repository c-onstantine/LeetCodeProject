package com.liming.offeragain;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-12-01 19:37
 * 剑指 Offer 59 - II. 队列的最大值
 */
public class Offer_II_59 {
    private Deque<Integer> queue;
    private Deque<Integer> maxdeque;

    public Offer_II_59() {
        queue = new ArrayDeque<>();
        maxdeque = new ArrayDeque<>();
    }

    public int max_value() {
        if (!maxdeque.isEmpty()) return maxdeque.peekFirst();
        return -1;
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxdeque.isEmpty() && maxdeque.peekLast() < value) maxdeque.pollLast();
        maxdeque.offerLast(value);
    }

    public int pop_front() {
        if (!queue.isEmpty()) {
            if (queue.peek().equals(maxdeque.peekFirst())) maxdeque.pollFirst();
            return queue.poll();
        }
        return -1;
    }
}
