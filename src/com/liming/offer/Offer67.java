package com.liming.offer;

/**
 * @author ltf
 * @date 2021-04-08 20:47
 */
public class Offer67 {
    public int strToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] c = str.trim().toCharArray();
        if (c.length == 0) return 0;
        int sign = 1, burry = Integer.MAX_VALUE / 10;
        int i = 1, res = 0;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            i = 0;
        }
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') break;
            if (res > burry || (res == burry && c[j] > '7')) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = 10 * res + (c[j] - '0');
        }
        return sign * res;
    }
}
