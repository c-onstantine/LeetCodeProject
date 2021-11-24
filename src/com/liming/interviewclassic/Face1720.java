package com.liming.interviewclassic;

import java.util.PriorityQueue;

/**
 * @author ltf
 * @date 2021-06-29 20:42
 */
public class Face1720 {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public Face1720() {
        left = new PriorityQueue<>((x, y) -> y - x);
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(left.size()>right.size()){
            right.offer(left.poll());
        }
        right.offer(num);
        left.offer(right.poll());
    }

    public double findMedian() {
        if (right.size() == left.size()) return (right.peek() + left.peek()) * 1.0 / 2;
        else return left.peek();
    }

}
