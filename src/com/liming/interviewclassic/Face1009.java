package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-05-18 21:17
 */
public class Face1009 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row != matrix.length && col != -1) {
            if (matrix[row][col] > target) {
                col -= 1;
            } else if (matrix[row][col] < target) {
                row += 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
