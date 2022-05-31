package com.liming.mid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2022-04-07 22:13
 */
public class DecodeString_394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> mutiStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        int muti = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                muti = 10 * muti + Integer.valueOf(c + "");
            } else if (c == '[') {
                mutiStack.offerFirst(muti);
                strStack.offerFirst(sb.toString());
                sb = new StringBuilder();
                muti = 0;
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int curMuti = mutiStack.pollFirst();
                for (int i = 0; i < curMuti; i++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder(strStack.pollFirst() + tmp);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
