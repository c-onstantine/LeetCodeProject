package com.liming.mietun;

/**
 * @author ltf
 * @date 2021-11-03 21:26
 * 498. 对角线遍历
 */
public class DiagonalTraverse_498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int index = 0;
        boolean flag = true;
        int pm, pn, x, y;
        for (int i = 0; i < m + n; i++) {
            pm = flag ? m : n;
            pn = flag ? n : m;
            x = (i < pm) ? i : pm - 1;
            y = i - x;
            while (x >= 0 && y < pn) {
                res[index++] = flag ? mat[x][y] : mat[y][x];
                x--;
                y++;
            }
            flag = !flag;
        }
        return res;
    }
}
