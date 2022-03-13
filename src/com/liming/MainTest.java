package com.liming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2022-03-11 13:21
 * 微软面试题
 */
public class MainTest {
    //所有可能的全排列结果集合。
    private static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3};
        //dfs(input,0,new ArrayList<>(),new boolean[input.length]);
        dfs1(input,0,new ArrayList<>());
        System.out.println(res);
    }
    // 从盒子里取出球  球出这些球的全排列
    private static  void dfs(int[] box,int deep,List<Integer> path,boolean[] vis){
        //当前取出了所有的球
        if(deep == box.length){
            //存入结果集合
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < box.length; i++){
            //取出之前没有取过的球
            if(!vis[i]){
                vis[i] = true;
                path.add(box[i]);
                // 取出一个之后继续向下深搜
                dfs(box,deep+1,path,vis);
                //回溯过程
                path.remove(path.size() - 1);
                vis[i] = false;
            }
        }
    }
    private static void dfs1(int[] box,int startIndex,List<Integer> path){
        res.add(new ArrayList<>(path));
        if(startIndex >= box.length){
            return;
        }
        for(int i = startIndex; i < box.length;i++){
            // 同层去重
            path.add(box[i]);
            dfs1(box,i+1,path);
            path.remove(path.size() - 1);
        }
    }
}
