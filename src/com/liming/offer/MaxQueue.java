package com.liming.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ltf
 * @date 2021-03-31 21:07
 */
public class MaxQueue {
    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public MaxQueue() {
        this.queue = new LinkedList<>();
        this.deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        if (queue.peek().equals(deque.peekFirst())) {
            deque.pollFirst();
        }
        return queue.poll();
    }
}
