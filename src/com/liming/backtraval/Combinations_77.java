package com.liming.backtraval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-17 19:49
 * 77. 组合  循环中剪枝  当n剩下的元素 已经不够填满path时 就不需要再遍历了。
 */
public class Combinations_77 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrace(n, k, 1);
        return res;
    }

    private void backtrace(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrace(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
