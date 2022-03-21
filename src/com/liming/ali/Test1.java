package com.liming.ali;

import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-03-14 19:35
 */
public class Test1 {
    /**
     * 2 4
     * 0 1 0 0
     * 1 0 1 0
     *
     * @param args
     */
    private static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        boolean leftflag = false;
        for (int i = 0; i < n; i++) {
            leftflag = false;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    leftflag = true;
                    continue;
                }
                if (leftflag && arr[i][j] == 0) {
                    res++;
                }
            }
        }
        boolean rightflag = false;
        for (int i = 0; i < n; i++) {
            rightflag = false;
            for (int j = m - 1; j >= 0; j--) {
                if (arr[i][j] == 1) {
                    rightflag = true;
                    continue;
                }
                if (rightflag && arr[i][j] == 0) {
                    res++;
                }
            }
        }
        boolean up = false;
        for (int i = 0; i < m; i++) {
            up = false;
            for (int j = 0; j < n; j++) {
                if (arr[j][i] == 1) {
                    up = true;
                    continue;
                }
                if (up && arr[j][i] == 0) {
                    res++;
                }
            }
        }
        boolean down = false;
        for (int i = 0; i < m; i++) {
            down = false;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j][i] == 1) {
                    down = true;
                    continue;
                }
                if (down && arr[j][i] == 0) {
                    res++;
                }
            }

        }
        System.out.println(res);
    }
    //private static void dfs(int[][] graph,int x, int y){
    //    if(x >= graph.length || x < 0 || y >= graph[0].length || y < 0)return;
    //    if(graph[x][y] == 1){
    //        res++;
    //        return;
    //    }
    //    dfs(graph,x + 1,y);
    //    dfs(graph,x - 1,y);
    //    dfs(graph,x,y + 1);
    //    dfs(graph,x,y - 1);
    //}
}
