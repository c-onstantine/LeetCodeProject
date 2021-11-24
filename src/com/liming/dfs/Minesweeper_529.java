package com.liming.dfs;

/**
 * @author ltf
 * @date 2021-07-29 19:30
 * 529. 扫雷游戏
 */
public class Minesweeper_529 {
    private int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    private int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(x, y, board);
        }
        return board;
    }

    private void dfs(int x, int y, char[][] board) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (isRight(x + dx[i], y + dy[i], board)) continue;
            if (board[x + dx[i]][y + dy[i]] == 'M') count++;
        }
        if (count > 0) {
            board[x][y] = (char) (count + '0');
            return;
        } else {
            board[x][y] = 'B';
        }
        for (int i = 0; i < 8; i++) {
            if (isRight(x + dx[i], y + dy[i], board) || board[x + dx[i]][y + dy[i]] != 'E') continue;
            dfs(x + dx[i], y + dy[i], board);
        }
    }

    private boolean isRight(int x, int y, char[][] board) {
        return x < 0 || x >= board.length || y < 0 || y >= board[0].length;
    }
}
