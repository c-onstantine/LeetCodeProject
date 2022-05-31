package com.liming.pdd;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-04-10 19:36
 */


public class Test2 {
    /**
     * 6
     * 4 4
     * K111
     * 1111
     * 1111
     * 111T
     * 2 3
     * K10
     * 00T
     * 2 3
     * K01
     * 11T
     * 4 4
     * K111
     * 1101
     * 1011
     * 111T
     * 3 3
     * KT1
     * 111
     * 111
     * 3 3
     * K11
     * 1T1
     * 111
     */
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            ans = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] chess = new char[n][m];
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                chess[i] = sc.nextLine().replaceAll(" ", "").toCharArray();
            }
            Deque<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (chess[i][j] == 'K') {
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            int[] dx = new int[]{0, 0, 1, -1};
            int[] dy = new int[]{1, -1, 0, 0};
            boolean hasT = false;
            label1:
            {
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    ans++;
                    for (int k = 0; k < size; k++) {
                        int[] poll = queue.poll();
                        chess[poll[0]][poll[1]] = '0';
                        for (int i = 0; i < 4; i++) {
                            int nx = poll[0] + dx[i];
                            int ny = poll[1] + dy[i];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m || chess[nx][ny] == '0') {
                                continue;
                            }
                            boolean flag = false;
                            if (i == 0) {
                                int nx1 = nx - 1;
                                int ny1 = ny + 1;
                                if (test1(m, n, nx1, ny1, chess)) {
                                    hasT = true;
                                    break label1;
                                }
                                flag |= test(m, n, nx1, ny1, chess, queue);
                                nx1 = nx + 1;
                                ny1 = ny + 1;
                                if (test1(m, n, nx1, ny1, chess)) {
                                    hasT = true;
                                    break label1;
                                }
                                flag |= test(m, n, nx1, ny1, chess, queue);

                            } else if (i == 1) {
                                int nx1 = nx - 1;
                                int ny1 = ny - 1;
                                if (test1(m, n, nx1, ny1, chess)) {
                                    hasT = true;
                                    break label1;
                                }
                                flag |= test(m, n, nx1, ny1, chess, queue);
                                nx1 = nx + 1;
                                if (test1(m, n, nx1, ny1, chess)) {
                                    hasT = true;
                                    break label1;
                                }
                                flag |= test(m, n, nx1, ny1, chess, queue);
                            } else if (i == 2) {
                                int nx1 = nx + 1;
                                int ny1 = ny - 1;
                                if (test1(m, n, nx1, ny1, chess)) {
                                    hasT = true;
                                    break label1;
                                }
                                flag |= test(m, n, nx1, ny1, chess, queue);
                                ny1 = ny + 1;
                                if (test1(m, n, nx1, ny1, chess)) {
                                    hasT = true;
                                    break label1;
                                }
                                flag |= test(m, n, nx1, ny1, chess, queue);
                            } else if (i == 3) {
                                int nx1 = nx - 1;
                                int ny1 = ny - 1;
                                if (test1(m, n, nx1, ny1, chess)) {
                                    hasT = true;
                                    break label1;
                                }
                                flag |= test(m, n, nx1, ny1, chess, queue);
                                ny1 = ny + 1;
                                if (test1(m, n, nx1, ny1, chess)) {
                                    hasT = true;
                                    break label1;
                                }
                                flag |= test(m, n, nx1, ny1, chess, queue);
                            }
                        }
                    }

                }
            }
            if (hasT) {
                System.out.println(ans);
            } else {
                System.out.println(-1);
            }
        }

    }

    private static boolean test(int m, int n, int x, int y, char[][] chess, Deque<int[]> queue) {
        if (x < 0 || x >= n || y < 0 || y >= m || chess[x][y] == '0') {
            return false;
        }
        chess[x][y] = '0';
        queue.offer(new int[]{x, y});
        return true;
    }

    private static boolean test1(int m, int n, int x, int y, char[][] chess) {
        if (x >= 0 && x < n && y >= 0 && y < m && chess[x][y] == 'T') {
            chess[x][y] = '0';
            return true;
        }
        return false;
    }
}
