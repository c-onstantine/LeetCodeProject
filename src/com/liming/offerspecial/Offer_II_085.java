package com.liming.offerspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2022-01-04 19:35
 */
public class Offer_II_085 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTracking(n, new StringBuilder(), res, 0, 0);
        return res;
    }

    private void backTracking(int n, StringBuilder sb, List<String> res, int left, int right) {
        if (left > n || right > left) return;
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        sb.append("(");
        backTracking(n, sb, res, left + 1, right);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        backTracking(n, sb, res, left, right + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
