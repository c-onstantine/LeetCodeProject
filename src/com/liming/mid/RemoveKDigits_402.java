package com.liming.mid;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2022-03-22 22:02
 */
public class RemoveKDigits_402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && c < stack.peekLast()) {
                k--;
                stack.pollLast();
            }
            if (c != '0' || !stack.isEmpty()) {
                stack.offerLast(c);
            }
        }
        // 目前已经是单调增的栈了 但是k还没有满足 从尾巴开始去
        while (k > 0 && !stack.isEmpty()) {
            k--;
            stack.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
