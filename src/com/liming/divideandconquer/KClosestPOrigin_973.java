package com.liming.divideandconquer;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ltf
 * @date 2022-03-01 9:48
 */
public class KClosestPOrigin_973 {
    private Random random = new Random();

    public int[][] kClosest(int[][] points, int k) {
        part(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void part(int[][] points, int left, int right, int k) {
        if (left >= right) return;
        int index = left + random.nextInt(right - left + 1);
        int pov = dist(points, index);
        swap(points,index,right);
        int j = left;
        for(int i = left; i < right; i++){
            if(dist(points,i) < pov){
                swap(points,i,j);
                j++;
            }
        }
        swap(points,j,right);
        if (k < j - left + 1) {
            part(points, left, j - 1, k);
        } else if(k > j - left + 1) {
            part(points, j + 1, right, k - (j - left + 1));
        }
    }
    private int dist(int[][] points, int index) {
        return points[index][0] * points[index][0] + points[index][1] * points[index][1];
    }

    private void swap(int[][] points, int i, int j) {
        int x = points[i][0], y = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = x;
        points[j][1] = y;
    }

    public static void main(String[] args) {
        new KClosestPOrigin_973().kClosest(new int[][]{{0,1},{1,0}},2);
    }
}
