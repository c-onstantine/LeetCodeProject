package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-18 21:04
 * 剑指 Offer 12. 矩阵中的路径
 */
public class Offer_12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == words[0]) {
                    if (dfs(board, words, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k]) return false;
        if (k == words.length - 1) return true;
        board[i][j] = '0';
        boolean res = dfs(board, words, i + 1, j, k + 1) ||
                dfs(board, words, i - 1, j, k + 1) ||
                dfs(board, words, i, j + 1, k + 1) ||
                dfs(board, words, i, j - 1, k + 1);
        //回溯
        board[i][j] = words[k];
        return res;
    }
}
