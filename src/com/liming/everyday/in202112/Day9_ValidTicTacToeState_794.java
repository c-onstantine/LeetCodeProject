package com.liming.everyday.in202112;

/**
 * @author ltf
 * @date 2021-12-09 16:08
 * 794. 有效的井字游戏
 * <p>
 * 由于 X 先手，O 后手，两者轮流下子。因此 O 的数量不会超过 X，且两者数量差不会超过1，否则为无效局面；
 * 若局面是 X 获胜，导致该局面的最后一个子必然是 X，此时必然有 X 数量大于 O（X 为先手），否则为无效局面；
 * 若局面是 O 获胜，导致该局面的最后一个子必然是 O，此时必然有 X 数量等于 O（X 为先手），否则为无效局面；
 * 局面中不可能出现两者同时赢（其中一方赢后，游戏结束）。
 */
public class Day9_ValidTicTacToeState_794 {
    public boolean validTicTacToe(String[] board) {
        char[][] chess = new char[3][3];
        int x = 0, o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') x++;
                else if (c == 'O') o++;
                chess[i][j] = c;
            }
        }
        boolean xx = check(chess, 'X'), oo = check(chess, 'O');
        if (o > x || x - o > 1) return false;
        if (xx && x <= o) return false;
        if (oo && x != o) return false;
        if (xx && oo) return false;
        return true;
    }

    private boolean check(char[][] chess, char a) {  // 用来判断这个字符是否赢了
        for (int i = 0; i < 3; i++) {
            if (chess[i][0] == a && chess[i][1] == a && chess[i][2] == a) return true; //行
            if (chess[0][i] == a && chess[1][i] == a && chess[2][i] == a) return true; // 列
        }
        // 对角线
        boolean b = true, c = true;  // 正对角 斜对角
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) b &= chess[i][j] == a;
                if (i + j == 2) c &= chess[i][j] == a;
            }
        }
        return c || b;
    }
}
