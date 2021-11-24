package com.liming.dfs;

import java.util.List;

/**
 * @author ltf
 * @date 2021-08-05 17:42
 * 841. 钥匙和房间
 */
public class KeysandRooms_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] vis = new int[rooms.size()];
        dfs(0, rooms, vis);
        for (int vi : vis) {
            if (vi == 0) return false;
        }
        return true;
    }

    private void dfs(int n, List<List<Integer>> rooms, int[] vis) {
        if (vis[n] == 1) return;
        vis[n] = 1;
        for (Integer i : rooms.get(n)) {
            dfs(i, rooms, vis);
        }
    }
}
