package com.liming.unionfindset;

/**
 * @author ltf
 * @date 2021-07-13 20:47
 * 990. 等式方程的可满足性
 */
public class SatisfiabilityofEqualityEquations_990 {
    private int[] fa;
    private int[] rank;

    public boolean equationsPossible(String[] equations) {
        init();
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (isConnected(equation.charAt(0) - 'a', equation.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    private void init() {
        fa = new int[26];
        rank = new int[26];
        for (int i = 0; i < 26; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int x) {
        while (x != fa[x]) {
            fa[x] = fa[fa[x]];
            x = fa[x];
        }
        return x;
    }

    private void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (rank[a] <= rank[b]) {
            fa[a] = b;
        } else {
            fa[b] = a;
        }
        if (rank[a] == rank[b]) {
            rank[b]++;
        }
    }

    private boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
