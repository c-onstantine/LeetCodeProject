package com.liming.ali;

/**
 * @author ltf
 * @date 2021-11-15 20:32
 * 1306. 跳跃游戏 III
 */
public class JumpGame_III {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start, new boolean[arr.length]);
    }

    private boolean dfs(int[] arr, int start, boolean[] vis) {
        if (start < 0 || start >= arr.length || vis[start]) return false;
        if (arr[start] == 0) return true;
        vis[start] = true;
        return dfs(arr, start + arr[start], vis) || dfs(arr, start - arr[start], vis);
    }
}
