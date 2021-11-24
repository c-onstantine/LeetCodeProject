package com.liming.backtraval;

/**
 * @author ltf
 * @date 2021-08-23 20:46
 */
public class SudokuSolver_37 {
    public void solveSudoku(char[][] board) {
        back(board);
    }

    private boolean back(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (int k = 0; k < 9; k++) {
                    if (isRight(board, i, j, (char) (k + '1'))) {
                        board[i][j] = (char) (k + '1');
                        if (back(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isRight(char[][] board, int x, int y, char val) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == val) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == val) return false;
        }
        int xx = (x / 3) * 3;
        int yy = (y / 3) * 3;
        for (int i = xx; i < xx + 3; i++) {
            for (int j = yy; j < yy + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }
        return true;
    }
}
