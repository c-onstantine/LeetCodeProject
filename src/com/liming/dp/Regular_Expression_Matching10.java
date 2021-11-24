package com.liming.dp;

import java.util.HashMap;

/**
 * @author ltf
 * @date 2021-02-15 12:34
 */
public class Regular_Expression_Matching10 {
    public boolean isMatch(String s, String p) {
        return dp(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean dp(char[] s, int i, char[] p, int j) {
        HashMap<String, Boolean> dptable = new HashMap<>();
        int m = s.length, n = p.length;
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p[j + 1] != '*') {
                    return false;
                }
            }
            return true;
        }
        String key = i + "," + j;
        if (dptable.containsKey(key)) return dptable.get(key);
        boolean res = false;
        if (s[i] == p[j] || p[j] == '.') {
            if (j < n - 1 && p[j + 1] == '*') {
                // * 匹配0个 或匹配一个 接下来接着匹配
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            //匹配0个
            if (j < n - 1 && p[j + 1] == '*') {
                res = dp(s, i, p, j + 2);
            } else {
                return false;
            }
        }
        dptable.put(key, res);
        return res;
    }
}
