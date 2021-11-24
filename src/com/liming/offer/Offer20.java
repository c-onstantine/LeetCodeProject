package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-02 21:13
 */
public class Offer20 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.contains(" ")) return false;
        if (s.length() == 0) return false;
        int[] a = {0};
        boolean flag = scanInteger(s, a);
        if (a[0] < s.length() && s.charAt(a[0]) == '.') {
            a[0]++;
            flag = scanUNInteger(s, a) || flag;
        }
        if (a[0] < s.length() && (s.charAt(a[0]) == 'e' || s.charAt(a[0]) == 'E')) {
            a[0]++;
            flag = flag && scanInteger(s, a);
        }
        return flag && a[0] == s.length();
    }

    private boolean scanUNInteger(String s, int[] a) {
        int tmp = a[0];
        while (a[0] < s.length() && s.charAt(a[0]) >= '0' && s.charAt(a[0]) <= '9') {
            a[0]++;
        }
        return tmp < a[0];
    }

    private boolean scanInteger(String s, int[] a) {
        if (a[0] < s.length() && (s.charAt(a[0]) == '+' || s.charAt(a[0]) == '-')) {
            a[0]++;
        }
        return scanUNInteger(s, a);
    }
}
