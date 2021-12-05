package com.liming.offeragain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author ltf
 * @date 2021-12-02 19:22
 */
public class Offer_38 {
    char[] c;

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        c = s.toCharArray();
        dfs(0, res);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x, List<String> res) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i, x);
            dfs(x + 1, res);
            swap(i, x);
        }
    }

    private void swap(int x, int y) {
        char tmp = c[x];
        c[x] = c[y];
        c[y] = tmp;
    }
}
