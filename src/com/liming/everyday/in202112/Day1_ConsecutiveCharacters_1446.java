package com.liming.everyday.in202112;

/**
 * @author ltf
 * @date 2021-12-01 10:11
 * 1446. 连续字符
 */
public class Day1_ConsecutiveCharacters_1446 {
    public int maxPower(String s) {
        int res = 1, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
                res = Math.max(res, cur);
            } else {
                cur = 1;
            }
        }
        return res;
    }
}
