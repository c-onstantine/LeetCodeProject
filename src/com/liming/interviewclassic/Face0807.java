package com.liming.interviewclassic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-05-07 21:14
 */
public class Face0807 {
    public String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(res, S.toCharArray(), 0, S.length());
        return res.toArray(new String[res.size()]);
    }

    private void dfs(List<String> res, char[] s, int k, int len) {
        if (k == len - 1) {
            res.add(new String(s));
            return;
        }
        for (int i = k; i < len; i++) {
            swap(s, k, i);
            dfs(res, s, k + 1, len);
            swap(s, k, i);
        }

    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
