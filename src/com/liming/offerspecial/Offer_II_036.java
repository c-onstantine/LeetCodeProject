package com.liming.offerspecial;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-12-17 11:59
 */
public class Offer_II_036 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int second = 0, first = 0;
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                second = stack.pollFirst();
                first = stack.pollFirst();
                stack.offerFirst(first + second);
            } else if ("-".equals(tokens[i])) {
                second = stack.pollFirst();
                first = stack.pollFirst();
                stack.offerFirst(first - second);
            } else if ("*".equals(tokens[i])) {
                second = stack.pollFirst();
                first = stack.pollFirst();
                stack.offerFirst(first * second);
            } else if ("/".equals(tokens[i])) {
                second = stack.pollFirst();
                first = stack.pollFirst();
                stack.offerFirst(first / second);
            } else {
                stack.offerFirst(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pollFirst();
    }
}
