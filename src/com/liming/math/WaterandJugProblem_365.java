package com.liming.math;

/**
 * @author ltf
 * @date 2021-07-23 17:52
 * 这道题也可以用深搜做 这里采用数学定理，裴蜀定理
 */
public class WaterandJugProblem_365 {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        if (jug1Capacity == 0 || jug2Capacity == 0) {
            return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        }
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }

    private int gcd(int x, int y) {
        int tmp = x % y;
        while (tmp != 0) {
            x = y;
            y = tmp;
            tmp = x % y;
        }
        return y;
    }
}
