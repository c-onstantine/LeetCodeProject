package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-30 20:13
 * 剑指 Offer 20. 表示数值的字符串
 */
public class Offer_20 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        char[] strs = s.trim().toCharArray();
        boolean hasnum = false;
        boolean hasdot = false;
        boolean hasE = false;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] >= '0' && strs[i] <= '9') {
                hasnum = true;
            } else if (strs[i] == '.') {
                //之前有. 或者e
                if (hasdot || hasE) {
                    return false;
                }
                hasdot = true;
            } else if (strs[i] == 'e' || strs[i] == 'E') {
                // 之前有e 或者之前没数字
                if (hasE || !hasnum) {
                    return false;
                }
                hasE = true;
                hasnum = false; // 防止没有指数的情况出现123e
            } else if (strs[i] == '-' || strs[i] == '+') {
                if (i != 0 && strs[i - 1] != 'e' && strs[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return hasnum;
    }

    public static void main(String[] args) {
        new Offer_20().isNumber(". 1");
    }
}
