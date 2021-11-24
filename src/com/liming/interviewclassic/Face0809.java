package com.liming.interviewclassic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-05-11 19:02
 */
public class Face0809 {
    private int n;
    private List<String> res;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        res = new ArrayList<>();
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String s) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, s + "(");
        }
        if (left < right) {
            dfs(left, right - 1, s + ")");
        }
    }
}
