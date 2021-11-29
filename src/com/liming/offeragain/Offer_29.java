package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-29 20:47
 * 剑指 Offer 29. 顺时针打印矩阵
 */
public class Offer_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int[] res = new int[matrix.length * matrix[0].length];
        int top = 0, down = matrix.length - 1, right = matrix[0].length - 1, left = 0;
        int index = 0;
        int i = 0;
        while (true) {
            for (i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top > down) break;
            for (i = top; i <= down; i++) {
                res[index++] = matrix[i][right];
            }
            if (--right < left) break;
            for (i = right; i >= left; i--) {
                res[index++] = matrix[down][i];
            }
            if (--down < top) break;
            for (i = down; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        new Offer_29().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }
}
