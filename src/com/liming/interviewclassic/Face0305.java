package com.liming.interviewclassic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ltf
 * @date 2021-04-26 19:50
 */
public class Face0305 {
    private List<Integer> list;

    public Face0305() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        list.add(val);
    }

    public void pop() {
        if (!list.isEmpty()) {
            Collections.sort(list);
            list.remove(list.get(0));
        }
    }

    public int peek() {
        if (!list.isEmpty()) {
            Collections.sort(list);
            return list.get(0);
        }
        return -1;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
