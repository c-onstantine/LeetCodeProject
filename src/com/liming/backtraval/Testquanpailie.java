package com.liming.backtraval;

/**
 * @author ltf
 * @date 2022-03-01 19:18
 * 不是全排列 需要把使用过的数字排除。
 */
public class Testquanpailie {
    public static void main(String[] args) {
        dfs(0,3,"");
    }
    private static void dfs(int deep,int total,String s){
        if(deep == total){
            System.out.println(s);
            return;
        }
        for(int i = 1; i <= total; i++){
            dfs(deep+1,total,s+" "+i);
        }
    }
}
