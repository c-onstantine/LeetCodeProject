package com.liming.offer;

/**
 * @author ltf
 * @date 2021-02-24 17:49
 */
public class Offer12 {
    private int cow;
    private int col;
    private int strlen;

    public static void main(String[] args) {
        char[][] board = {{'a'}};
        String word = "ab";
        System.out.println(new Offer12().exist(board, word));
    }
    public  boolean exist(char[][] board, String word) {
        cow = board.length;
        col = board[0].length;
        strlen = word.length();
        boolean[][] vis = new boolean[cow][col];
        for (int i = 0; i < cow; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int deep, boolean[][] vis) {
        if (deep == strlen) return true;
        boolean flag = false;
        if (x >= 0 && x < cow && y >= 0 && y < col && board[x][y] == word.charAt(deep) && vis[x][y] == false) {
            vis[x][y] = true;
            deep++;
            flag = dfs(board, x + 1, y, word, deep, vis)
                    || dfs(board, x - 1, y, word, deep, vis)
                    || dfs(board, x, y + 1, word, deep, vis)
                    || dfs(board, x, y - 1, word, deep, vis);
            if (!flag) {
                deep--;
                vis[x][y] = false;
            }
        }
        return flag;
    }
}
