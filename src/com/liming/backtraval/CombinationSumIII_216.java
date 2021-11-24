package com.liming.backtraval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-17 20:22
 * 216. 组合总和 III
 */
public class CombinationSumIII_216 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrace(n, k, 1);
        return res;
    }

    private void backtrace(int n, int k, int start) {
        if (n < 0) return;
        if (path.size() == k) {
            if (n == 0) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 9 - (k - path.size()) + 1; i++) {
            n -= i;
            path.add(i);
            backtrace(n, k, i + 1);
            n += i;
            path.remove(path.size() - 1);
        }
    }

}
