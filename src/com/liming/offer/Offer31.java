package com.liming.offer;

import java.util.Stack;

/**
 * @author ltf
 * @date 2021-03-10 14:44
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index1 = 0;
        int index2 = 0;
        int m = pushed.length;
        int n = popped.length;
        if (m == 0 && n == 0) return true;
        if (m == 0 || n == 0) return false;
        Stack<Integer> tmp = new Stack<>();
        boolean flag = false;
        while (index2 < n) {
            while (tmp.isEmpty() || tmp.peek() != popped[index2]) {
                if (index1 == m) break;
                tmp.push(pushed[index1]);
                index1++;
            }
            if (tmp.peek() != popped[index2]) break;
            tmp.pop();
            index2++;
        }
        if (tmp.isEmpty() && index2 == n) flag = true;
        return flag;
    }

}
