package com.liming.mid;

/**
 * @author ltf
 * @date 2022-04-06 10:14
 */
public class Searcha2DMatrixII_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix[0].length - 1;
        while (left < matrix.length && right >= 0) {
            if (matrix[left][right] == target) {
                return true;
            } else if (matrix[left][right] < target) {
                left++;
            } else if (matrix[left][right] > target) {
                right--;
            }
        }
        return false;
    }
}
