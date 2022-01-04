package com.liming.offerspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2022-01-04 20:27
 */
public class Offer_II_087 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length()<4||s.length() > 12) return res;
        backTracking(s, 0, 0);
        return res;
    }

    private void backTracking(String s, int start, int pointCount) {
        if (pointCount == 3) {
            if (isValid(s, start, s.length() - 1)) {
                res.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isValid(s, start, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                backTracking(s, i + 2, pointCount + 1);
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else break;

        }
    }

    private boolean isValid(String s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && start != end) return false; // 前导0
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') return false;
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum > 255) return false;
        }
        return true;
    }
}
