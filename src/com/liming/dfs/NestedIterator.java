package com.liming.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author ltf
 * @date 2021-07-22 17:40
 * 341. 扁平化嵌套列表迭代器
 * 利用栈 迭代实现
 */
public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.addFirst(nestedList.get(i));
        }
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger nestint = stack.peekFirst();
            if (nestint.isInteger()) {
                return true;
            }
            stack.pollFirst();
            List<NestedInteger> list = nestint.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.addFirst(list.get(i));
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        return stack.pollFirst().getInteger();
    }

    private interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
