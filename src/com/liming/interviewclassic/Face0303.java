package com.liming.interviewclassic;

import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-04-22 20:57
 * 面试题 03.03. 堆盘子
 */
public class Face0303 {
    private LinkedList<LinkedList<Integer>> setOfStacke;
    private int cap;

    public Face0303(int cap) {
        this.setOfStacke = new LinkedList<>();
        this.cap = cap;
    }

    private boolean isSetEmpty() {
        return setOfStacke.isEmpty();
    }

    private boolean isLastFull() {
        return isSetEmpty() ? true : setOfStacke.getLast().size() >= cap;
    }

    private boolean isLastEmpty() {
        return setOfStacke.getLast().isEmpty();
    }

    public void push(int val) {
        if (cap <= 0) return;
        if (isLastFull()) {
            setOfStacke.add(new LinkedList<>());
        }
        setOfStacke.getLast().add(val);
    }

    public int pop() {
        int res = -1;
        if (isSetEmpty()) {
            return res;
        }
        res = setOfStacke.getLast().removeLast();
        if (isLastEmpty()) {
            setOfStacke.removeLast();
        }
        return res;
    }

    public int popAt(int index) {
        int res = -1;
        if (isSetEmpty() || index > setOfStacke.size() - 1) {
            return res;
        }
        res = setOfStacke.get(index).removeLast();
        if (setOfStacke.get(index).isEmpty()) {
            setOfStacke.remove(index);
        }
        return res;
    }
}
