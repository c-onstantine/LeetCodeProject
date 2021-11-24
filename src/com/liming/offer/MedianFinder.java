package com.liming.offer;

import java.util.PriorityQueue;

/**
 * @author ltf
 * @date 2021-03-19 16:21
 * offer 41
 */
public class MedianFinder {
    private PriorityQueue<Integer> Q1, Q2;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        Q1 = new PriorityQueue<>(); // 小根堆
        Q2 = new PriorityQueue<>((x, y) -> y - x);
    }

    public void addNum(int num) {
        if (Q1.size() != Q2.size()) {
            Q1.offer(num);
            Q2.offer(Q1.poll());
        } else {
            Q2.offer(num);
            Q1.offer(Q2.poll());
        }
    }

    public double findMedian() {
        if (Q1.size() != Q2.size()) {
            return Q1.peek();
        } else {
            return (Q1.peek() + Q2.peek()) / 2.0;
        }
    }
}
