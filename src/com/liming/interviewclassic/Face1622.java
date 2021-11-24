package com.liming.interviewclassic;

import java.util.*;

/**
 * @author ltf
 * @date 2021-06-16 19:42
 * 面试题 16.22. 兰顿蚂蚁  太恶心了
 */
public class Face1622 {
    private class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public List<String> printKMoves(int K) {
        char[] direction = {'L', 'U', 'R', 'D'};
        int[][] offset = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Position antPos = new Position(0, 0);
        int antDir = 2; // 初始向右
        Set<Position> blackgrid = new HashSet<>();
        while (K > 0) {
            Position s = new Position(antPos.x, antPos.y);
            if (blackgrid.add(s)) { // 能放进去 说明是白色，直接顺时针转
                antDir = (antDir + 1) % 4;
            } else { //放不进去 说明是黑色 反转颜色 移除set
                antDir = (antDir + 3) % 4;
                blackgrid.remove(s);
            }
            antPos.x += offset[antDir][0];
            antPos.y += offset[antDir][1];
            K--;
        }
        int left = antPos.x, right = antPos.x, top = antPos.y, bottom = antPos.y;
        for (Position pos : blackgrid) {
            left = pos.x < left ? pos.x : left;
            right = pos.x > right ? pos.x : right;
            top = pos.y < top ? pos.y : top;
            bottom = pos.y > bottom ? pos.y : bottom;
        }
        char[][] grid = new char[bottom - top + 1][right - left + 1];
        for (char[] chars : grid) {
            Arrays.fill(chars, '_');
        }
        for (Position position : blackgrid) {
            grid[position.y - top][position.x - left] = 'X';
        }
        grid[antPos.y - top][antPos.x - left] = direction[antDir];
        List<String> res = new ArrayList<>();
        for (char[] chars : grid) {
            res.add(new String(chars));
        }
        return res;
    }
}
