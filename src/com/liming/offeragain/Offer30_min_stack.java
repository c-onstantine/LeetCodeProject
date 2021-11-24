package com.liming.offeragain;

import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-11-05 14:51
 */
public class Offer30_min_stack {
    private LinkedList<Integer> data, helper;

    public Offer30_min_stack() {
        data = new LinkedList<>();
        helper = new LinkedList<>();
    }

    public void push(int x) {
        data.offerFirst(x);
        if (helper.isEmpty() || helper.peekFirst() >= x) {
            helper.offerFirst(x);
        }
    }

    public void pop() {
        if (data.pollFirst().equals(helper.peekFirst())) {
            helper.pollFirst();
        }
    }

    public int top() {
        return data.peekFirst();
    }

    public int min() {
        return helper.peekFirst();
    }
}
