package com.liming.offeragain;

import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-11-05 14:31
 * 剑指 Offer 09. 用两个栈实现队列   简单
 */
public class Offer09_stack_as_queue {
    private LinkedList<Integer> a, b;

    public Offer09_stack_as_queue() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void appendTail(int value) {
        a.offerFirst(value);
    }

    public int deleteHead() {
        if (!b.isEmpty()) return b.pollFirst();
        if (a.isEmpty()) return -1;
        while (!a.isEmpty()) {
            b.offerFirst(a.pollFirst());
        }
        return b.pollFirst();
    }
}
