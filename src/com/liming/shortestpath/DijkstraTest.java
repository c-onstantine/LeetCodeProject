package com.liming.shortestpath;

/**
 * @author ltf
 * @date 2022-03-30 14:37
 */
public class DijkstraTest {

    private int mEdgNum;        // 边的数量
    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   // 最大值
    /*
     * Dijkstra最短路径。
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     *
     * 参数说明：
     *       vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
     *     prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
     *     dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
     */
    public void dijkstra(int vs, int[] prev, int[] dist) {
        // 记录当前点是不是已经求出了最短路径了
        boolean[] flag = new boolean[mVexs.length];

        for (int i = 0; i < mVexs.length; i++) {
            prev[i] = 0; // 所有顶点前驱为0
            dist[i] = mMatrix[vs][i];
        }

        //初始化起始点
        flag[vs] = true;
        dist[vs] = 0;
        int k = 0;
        for (int i = 0; i < mVexs.length; i++) {
            int min = INF;
            // 选取最短的路径
            for (int j = 0; j < mVexs.length; j++) {
                if(flag[j] == false && dist[j] < min){
                    min = dist[j];
                    k = j;
                }
            }
            flag[k] = true;
            for (int j = 0; j < mVexs.length; j++) {
                int tmp = (mMatrix[k][j] == INF ? INF : (min + mMatrix[k][j]));
                if(flag[j] == false && tmp < dist[j]){
                    dist[j] = tmp;
                    prev[j] = k; // 更新当前点的前驱
                }
            }
        }
    }

}
