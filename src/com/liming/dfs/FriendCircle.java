package com.liming.dfs;

/**
 * @author ltf
 * @date 2020-10-22 19:00
 */
public class FriendCircle {
    public int findCircleNum(int[][] M) {
        int[] vis=new int[M.length];
        int sum=0;
        for(int i=0;i<M.length;i++){
            if(vis[i]==0){
                vis[i]=1;
                dfs(M,vis,i);
                sum++;
            }
        }
        return sum;
    }
    public void dfs(int[][] M,int[] vis,int j){
       for(int i=0;i<M.length;i++){
           if(M[j][i]==1&&vis[i]==0){
               vis[i]=1;
               dfs(M,vis,i);
           }
       }
    }
}
