package com.liming;

import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-03-14 20:16
 * 消消乐题目
 */
public class Main3 {
    /**
     * 2
     * rbbbrrrb
     * ggggbrbr
     * rrrggbrr
     * gbrgbrrr
     * bgbgrrrg
     * bgbgbrrb
     * rggrgggg
     * bgbrgrgr
     * bbrgggggbbgbbbrg
     * bbgbrgbgbbgbbbrg
     * brgbgbbggbbgbbbr
     * gbbgbbbrggrbbgrb
     * bgrbbrgggrbrgbrr
     * brgbrgbrgrgbrgbr
     * brbbrbbbrbrrggrg
     * ggrbrgbgbrgggrbr
     * 1 5 w
     * 1 4 d
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] chess = new char[8][8];
        sc.nextLine();
        for (int i = 0; i < 8; i++) {
            chess[i] = sc.nextLine().toCharArray();
        }
        String[] nextstr = new String[8];
        for (int i = 0; i < 8; i++) {
            nextstr[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            char op = s[2].charAt(0);

        }
    }
    private void dfs(char[][] chess,int x,int y){
        if(x >= chess.length || x < 0 || y >= chess[0].length || y < 0) return;
        char c = chess[x][y];
        chess[x][y] = '*';
        if(chess[x+1][y] == c){
            dfs(chess,x+1,y);
        }
        if(chess[x - 1][y] == c){
            dfs(chess,x - 1,y);
        }
        if(chess[x][y + 1] == c){
            dfs(chess,x,y+1);
        }
        if(chess[x][y - 1] == c){
            dfs(chess,x,y - 1);
        }
    }
}
