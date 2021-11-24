package com.liming.interviewclassic;

import java.util.Arrays;

/**
 * @author ltf
 * 面试题 17.05.  字母与数字
 * @date 2021-06-21 19:38
 */
public class Face1705 {
    public String[] findLongestSubarray(String[] array) {
        int len = array.length;
        int[] memo = new int[(len << 1) + 1];
        Arrays.fill(memo, -2);
        memo[len] = -1;
        int res = 0, count = 0, begin = 0, end = 0;
        for (int i = 0; i < len; i++) {
            boolean is_num = true;
            for (char c : array[i].toCharArray()) {
                if (c < '0' || c > '9') {
                    is_num = false;
                    break;
                }
            }
            count += is_num ? -1 : 1;
            if (memo[count + len] <= -2) {
                memo[count + len] = i;
            } else if (i - memo[count + len] > res) {
                res = i - memo[count + len];
                begin = memo[count + len] + 1;
                end = i + 1;
            }
        }
        return Arrays.copyOfRange(array, begin, end);
    }
}
