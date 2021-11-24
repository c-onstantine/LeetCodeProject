package com.liming.unionfindset;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2020-10-21 21:11
 */
public class FriendCircle {
    private int[] parent;

    private int find(int x) {
        if (parent[x] < 0) {
            return x;
        }
        // 优化find流程，避免退化成链表形式，find只关注最终是否能找到同一个树根，故将find路径上的点直接挂在树根节点
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        int xset = find(x);
        int yset = find(y);
        if (xset != yset) {
            parent[xset] = yset;
        }
    }

    public int findCircleNum(int[][] M) {
        parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            // 因为连接的特殊性，A与B存在关系则B与A必定存在关系，故可以按照数组对角线裁剪掉一半的路径
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // 统计数组中最终还为-1的个数，所以的-1均代表一个union的顶点，也就是一个朋友圈

        // 使用stream流求和，语法简洁 但对于基础类型数据来讲，stream操作反而更慢
        // return (int) Arrays.stream(parent).filter(x -> x == -1).count();
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

}
