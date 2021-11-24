package com.liming.backtraval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-22 15:55
 * 51. N 皇后
 */
public class N_Queens_51 {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        back(chess, 0);
        return res;
    }

    private void back(char[][] chess, int row) {
        if (row == chess.length) {
            res.add(concat(chess));
            return;
        }
        for (int i = 0; i < chess.length; i++) {
            if (isRight(row, i, chess)) {
                chess[row][i] = 'Q';
                back(chess, row + 1);
                chess[row][i] = '.';
            }
        }
    }

    private boolean isRight(int row, int col, char[][] chess) {
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> concat(char[][] chess) {
        List<String> tmp = new ArrayList<>();
        for (char[] chars : chess) {
            tmp.add(new String(chars));
        }
        return tmp;
    }
}
