package com.liming.backtraval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-19 16:42
 * 131. 分割回文串
 */
public class PalindromePartitioning_131 {
    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        back(s, 0);
        return res;
    }

    private void back(String s, int start) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isHuiWen(s, start, i)) {
                path.add(s.substring(start, i + 1));
            } else {
                continue;
            }
            back(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isHuiWen(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
