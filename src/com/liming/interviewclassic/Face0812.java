package com.liming.interviewclassic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ltf
 * @date 2021-05-11 21:21
 */
public class Face0812 {
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        char[][] dev = new char[n][n];
        res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dev[i], '.');
        }
        dfs(dev, n, 0);
        return res;
    }

    private void dfs(char[][] dev, int n, int deep) {
        if (deep == n) {
            ArrayList<String> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tmp.add(new String(dev[i]));
            }
            res.add(tmp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isRight(dev, deep, col, n)) {
                dev[deep][col] = 'Q';
                dfs(dev, n, deep + 1);
                dev[deep][col] = '.';
            }
        }
    }

    private boolean isRight(char[][] dev, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (dev[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (dev[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (dev[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
