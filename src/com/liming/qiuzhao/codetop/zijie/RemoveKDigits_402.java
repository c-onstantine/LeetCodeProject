package com.liming.qiuzhao.codetop.zijie;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2022-08-09 8:51
 */
public class RemoveKDigits_402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && c < stack.peekFirst()) {
                k--;
                stack.pollFirst();
            }
            if (c != '0' || !stack.isEmpty()) {
                stack.offerFirst(c);
            }
        }
        while (k > 0 && !stack.isEmpty()) {
            k--;
            stack.pollFirst();
        }
        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
