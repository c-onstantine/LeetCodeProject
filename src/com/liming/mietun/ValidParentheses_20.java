package com.liming.mietun;

import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-11-01 21:43
 * 20. 有效的括号 简单题
 */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(')');
            } else if (c == '[') {
                stack.offerFirst(']');
            } else if (c == '{') {
                stack.offerFirst('}');
            } else if (stack.isEmpty() || c != stack.pollFirst()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
