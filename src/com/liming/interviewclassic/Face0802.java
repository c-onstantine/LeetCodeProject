package com.liming.interviewclassic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-05-06 20:55
 */
public class Face0802 {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> path = new ArrayList<>();
        if (dfs(0, 0, path, obstacleGrid)) {
            return path;
        } else {
            return new ArrayList<>();
        }
    }

    private boolean dfs(int x, int y, List<List<Integer>> path, int[][] obstacleGrid) {
        if (x >= obstacleGrid.length || y >= obstacleGrid[0].length || obstacleGrid[x][y] == 1) {
            return false;
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(x);
        tmp.add(y);
        path.add(tmp);
        if ((x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) || dfs(x + 1, y, path, obstacleGrid) || dfs(x, y + 1, path, obstacleGrid)) {
            return true;
        }
        path.remove(path.size() - 1);
        //剪枝
        obstacleGrid[x][y] = 1;

        return false;
    }
}
