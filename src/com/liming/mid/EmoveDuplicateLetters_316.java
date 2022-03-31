package com.liming.mid;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2022-03-23 9:33
 * 316. 去除重复字母
 * 思路 单调栈 当加入栈中的元素比栈顶的字典序小 并且之后还会出现栈顶的元素 就把栈顶元素抛出 相当于让字典序小的元素站在前面。
 */
public class EmoveDuplicateLetters_316 {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) return s;
        int[] count = new int[128]; // 记录每个字符出现次数
        boolean[] isInStack = new boolean[128];
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : s.toCharArray()) {
            count[c]--;
            if (isInStack[c]) continue;
            while (!stack.isEmpty() && stack.peekLast() > c) {
                if (count[stack.peekLast()] == 0) {
                    break;
                }
                isInStack[stack.pollLast()] = false;
            }
            stack.offerLast(c);
            isInStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
