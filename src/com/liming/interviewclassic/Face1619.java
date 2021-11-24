package com.liming.interviewclassic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ltf
 * @date 2021-06-09 21:13
 * bfs 面试题 16.19. 水域大小
 */
public class Face1619 {
    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    list.add(dfs(land, i, j));
                }
            }
        }
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(res);
        return res;
    }

    private int dfs(int[][] land, int x, int y) {
        int sum = 0;
        if (x < 0 || x >= land.length || y < 0 || y >= land[0].length || land[x][y] != 0) {
            return sum;
        }
        sum += 1;
        land[x][y] = 1;
        sum += dfs(land, x, y + 1);
        sum += dfs(land, x, y - 1);
        sum += dfs(land, x + 1, y);
        sum += dfs(land, x - 1, y);
        sum += dfs(land, x + 1, y + 1);
        sum += dfs(land, x - 1, y - 1);
        sum += dfs(land, x + 1, y - 1);
        sum += dfs(land, x - 1, y + 1);
        return sum;
    }
}
