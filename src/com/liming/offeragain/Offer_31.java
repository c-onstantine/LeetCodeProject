package com.liming.offeragain;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-11-29 21:32
 */
public class Offer_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int num : pushed) {
            stack.offerFirst(num);
            while (!stack.isEmpty() && stack.peekFirst() == popped[index]) {
                stack.pollFirst();
                index++;
            }
        }
        return index == popped.length;
    }
}
