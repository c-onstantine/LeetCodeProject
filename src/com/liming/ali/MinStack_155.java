package com.liming.ali;

import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-11-15 21:02
 * 155. 最小栈
 */
public class MinStack_155 {
    private LinkedList<Integer> stack;
    private int min;

    public MinStack_155() {
        this.stack = new LinkedList<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min) {
            stack.offerLast(min);
            min = val;
        }
        stack.offerLast(val);
    }

    public void pop() {
        Integer i = stack.pollLast();
        if (i == min) {
            min = stack.pollLast();
        }
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return min;
    }
}
