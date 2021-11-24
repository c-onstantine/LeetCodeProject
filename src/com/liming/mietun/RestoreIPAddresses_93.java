package com.liming.mietun;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ltf
 * @date 2021-10-27 19:35
 */
public class RestoreIPAddresses_93 {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }
        Stack<String> path = new Stack<>();
        dfs(s, 0, len, 4, path, res);
        return res;
    }

    private void dfs(String s, int begin, int len, int split, Stack<String> path, List<String> res) {
        if (begin == len) {
            if (split == 0) {
                res.add(String.join(".", path));
                return;
            }
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) break;
            if (split * 3 < len - i) continue; // 剩余数字 每段分三个都剩余 则说明剩多了 不能从这里截断
            if (judgeIpRight(s, begin, i)) {
                String sub = s.substring(begin, i + 1);
                path.push(sub);
                dfs(s, i + 1, len, split - 1, path, res);
                path.pop();
            }
        }
    }

    private boolean judgeIpRight(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') return false;
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}
