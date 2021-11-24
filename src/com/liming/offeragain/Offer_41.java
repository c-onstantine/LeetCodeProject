package com.liming.offeragain;

import java.util.PriorityQueue;

/**
 * @author ltf
 * @date 2021-11-22 19:47
 * 剑指 Offer 41. 数据流中的中位数  困难
 */
public class Offer_41 {
    private PriorityQueue<Integer> smallHeap;
    private PriorityQueue<Integer> bigHeap;

    public Offer_41() {
        this.smallHeap = new PriorityQueue<>();
        this.bigHeap = new PriorityQueue<>((x, y) -> y - x);
    }

    public void addNum(int num) {
        if (smallHeap.size() == bigHeap.size()) {
            bigHeap.offer(num);
            smallHeap.offer(bigHeap.poll());
        } else {
            smallHeap.offer(num);
            bigHeap.offer(smallHeap.poll());
        }
    }

    public double findMedian() {
        if (smallHeap.size() == bigHeap.size()) {
            return (double) (smallHeap.peek() + bigHeap.peek()) / 2;
        } else {
            return (double) smallHeap.peek();
        }
    }
}
