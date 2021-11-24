package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-06-28 20:21
 */
public class Face1723 {
    public int[] findSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int len = matrix.length;
        int[] res = new int[3];
        int[][] matrow = new int[len][len];
        int[][] matcol = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    matrow[i][j] = 1 + (i < len - 1 ? matrow[i + 1][j] : 0);
                    matcol[i][j] = 1 + (j < len - 1 ? matcol[i][j + 1] : 0);
                }

            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int startsize = Math.min(matrow[i][j], matcol[i][j]);
                int endsize = res[2];
                for (int k = startsize; k > endsize; k--) {
                    if (matcol[i + k - 1][j] >= k && matrow[i][j + k - 1] >= k) {
                        res[0] = i;
                        res[1] = j;
                        res[2] = k;
                        break;
                    }
                }
            }
        }
        if (res[2] == 0) return new int[0];
        return res;
    }
}
