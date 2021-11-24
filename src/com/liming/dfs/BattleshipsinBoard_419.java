package com.liming.dfs;

/**
 * @author ltf
 * @date 2021-07-26 19:55
 * 419. 甲板上的战舰
 */
public class BattleshipsinBoard_419 {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) return 0;
        int row = board.length;
        int col = board[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X') {
                    res++;
                    board[i][j] = '.';
                    int a = i + 1;
                    int b = j;
                    while (a < row && board[a][b] == 'X') {
                        board[a++][b] = '.';
                    }
                    a = i;
                    b = j + 1;
                    while (b < col && board[a][b] == 'X') {
                        board[a][b++] = '.';
                    }
                }
            }
        }
        return res;
    }
}
