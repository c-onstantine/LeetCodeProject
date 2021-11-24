package com.liming.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-07-26 19:35
 */
public class LexicographicalNumbers_386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dfs(n, i, res);
        }
        return res;
    }

    private void dfs(int n, int i, List<Integer> res) {
        if (i > n) return;
        res.add(i);
        for (int j = 0; j < 10; j++) {
            dfs(n, i * 10 + j, res);
        }
    }
}
