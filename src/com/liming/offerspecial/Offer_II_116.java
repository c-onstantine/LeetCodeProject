package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2022-01-13 16:30
 */
public class Offer_II_116 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                res++;
                dfs(isConnected, vis, i);
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, boolean[] vis, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !vis[j]) {
                vis[j] = true;
                dfs(isConnected, vis, j);
            }
        }
    }
}
