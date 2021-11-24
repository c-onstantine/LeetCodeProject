package com.liming.mid;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-08-24 17:24
 * 787. K 站中转内最便宜的航班  贝尔曼弗德
 */
public class CheapestFlightWithinKStops_787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dest = new int[n];
        int INF = 0x3f3f3f3f;
        Arrays.fill(dest, INF);
        dest[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] clone = dest.clone();
            for (int[] flight : flights) {
                dest[flight[1]] = Math.min(dest[flight[1]], clone[flight[0]] + flight[2]);
            }
        }
        return dest[dst] > INF / 2 ? -1 : dest[dst];
    }
}
