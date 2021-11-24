package com.liming.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-03-10 12:44
 * Offer30
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    private List<Integer> data;
    private List<Integer> helper;
    private int datapoint;
    private int helppoint;

    public MinStack() {
        this.data = new ArrayList<>(10000);
        this.helper = new ArrayList<>(10000);
        this.datapoint = 0;
        this.helppoint = 0;
    }

    public void push(int x) {
        data.add(datapoint++, x);
        if (helper.size() == 0 || x < min()) {
            helper.add(helppoint++, x);
        } else {
            helper.add(helppoint, min());
            helppoint++;
        }
    }

    public void pop() {
        data.remove(--datapoint);
        helper.remove(--helppoint);
    }

    public int top() {
        return data.get(datapoint - 1);
    }

    public int min() {
        return helper.get(helppoint - 1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();
    }
}
