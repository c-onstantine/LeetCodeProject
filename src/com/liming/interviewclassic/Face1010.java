package com.liming.interviewclassic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-05-20 19:03
 * 面试题 10.10. 数字流的秩\
 * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说：
 * <p>
 * 实现 track(int x) 方法，每读入一个数字都会调用该方法；
 * <p>
 * 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
 * <p>
 * 注意：本题相对原题稍作改动
 */
public class Face1010 {
    private List<Integer> list;

    public Face1010() {
        this.list = new ArrayList<>();
    }

    public void track(int x) {
        list.add(x);
    }

    public int getRankOfNumber(int x) {
        int res = 0;
        for (Integer num : list) {
            if (num <= x) {
                res++;
            }
        }
        return res;
    }
}
