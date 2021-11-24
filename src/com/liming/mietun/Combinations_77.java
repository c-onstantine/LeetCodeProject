package com.liming.mietun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-10-28 20:56
 * 77. 组合
 */
public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        traceBack(n, k, 1, res, new ArrayList<>());
        return res;
    }

    private void traceBack(int n, int k, int start, List<List<Integer>> res, List<Integer> tmp) {
        if (k == tmp.size()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= n - (k - tmp.size()) + 1; i++) {
            tmp.add(i);
            traceBack(n, k, i + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
