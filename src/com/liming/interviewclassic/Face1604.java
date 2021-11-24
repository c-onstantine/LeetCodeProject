package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-05-25 21:15
 */
public class Face1604 {
    public String tictactoe(String[] board) {
        int len = board.length;
        int row = 0;
        int col = 0;
        int left = 0;
        int right = 0;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            row = col = 0;
            for (int j = 0; j < len; j++) {
                row += board[i].charAt(j);
                col += board[j].charAt(i);
                if (board[i].charAt(j) == ' ') {
                    flag = true;
                }
            }
            if (row == (int) 'X' * len || col == (int) 'X' * len) return "X";
            if (row == (int) 'O' * len || col == (int) 'O' * len) return "O";
            left += board[i].charAt(i);
            right += board[i].charAt(len - i - 1);
        }
        if (left == (int) 'X' * len || right == (int) 'X' * len) return "X";
        if (left == (int) 'O' * len || right == (int) 'O' * len) return "O";
        if (flag) {
            return "Pending";
        }
        return "Draw";
    }
}
