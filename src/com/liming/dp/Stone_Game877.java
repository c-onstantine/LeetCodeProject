package com.liming.dp;

/**
 * @author ltf
 * @date 2021-01-19 14:09
 */
public class Stone_Game877 {
    class Pair {
        int fir, sec;
        Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        Pair[][] dp =new Pair[length][length];
        for(int i=0;i<length;i++){
            for(int j=i; j<length;j++){
                dp[i][j]=new Pair(0,0);
            }
        }
        for(int i=0;i<length;i++){
            dp[i][i].fir=piles[i];
            dp[i][i].sec=0;
        }
        for(int l=2;l<=length;l++){
            for(int i=0;i<=length-l;i++){
                int j=l+i-1;
                int left=piles[i]+dp[i+1][j].sec;
                int right=piles[j]+dp[i][j-1].sec;
                if(left>right){
                    dp[i][j].fir=left;
                    dp[i][j].sec=dp[i+1][j].fir;
                }else{
                    dp[i][j].fir=right;
                    dp[i][j].sec=dp[i][j-1].fir;
                }
            }
        }
        Pair pair = dp[0][length - 1];
        return pair.fir-pair.sec>0?true:false;
    }
}
