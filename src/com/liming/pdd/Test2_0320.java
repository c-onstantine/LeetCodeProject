package com.liming.pdd;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-03-20 19:17
 */
public class Test2_0320 {
    private static int time = 0;
    private static PriorityQueue<Land> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            int v = sc.nextInt();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int ki = sc.nextInt();
                int ai = sc.nextInt();
                int bi = sc.nextInt();
                Land land = new Land(ai, ki, bi);
                queue.offer(land);
            }
            time = queue.peek().ai;
            while (!queue.isEmpty()) {
                Land poll = queue.poll();
                if (poll.bi >= time) {
                    if (poll.ki > v) {
                        poll.ki -= v;
                        ans += v;
                        queue.offer(poll);
                    } else if (poll.ki == v) {
                        ans += v;
                    } else {
                        ans += poll.ki;
                    }
                }
                time++;
            }
            System.out.println(ans);
        }
    }



    private static class Land implements Comparable<Land> {
        private int ai;
        private int ki;
        private int bi;

        public Land(int ai, int ki, int bi) {
            this.ai = ai;
            this.ki = ki;
            this.bi = bi;
        }

        @Override
        public int compareTo(Land o) {
            if(ai == o.ai){
                if(bi == o.bi){
                    return o.ki - ki;
                }
                return bi - o.bi;
            }else {
                return ai - o.ai;
            }
        }
    }
}
