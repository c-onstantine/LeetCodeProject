package com.liming.offer;

import java.util.Stack;

/**
 * @author ltf
 * @date 2021-02-21 15:13
 */
public class Offer09 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (stack1.size() > 0) {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        if (stack2.isEmpty()) return -1;
        return stack2.pop();
    }
}
