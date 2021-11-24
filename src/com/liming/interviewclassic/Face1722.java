package com.liming.interviewclassic;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-06-22 20:14
 * DFS + 回溯剪枝
 */
public class Face1722 {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> res = new LinkedList<>();
        boolean[] vis = new boolean[wordList.size()];
        if (dfs(beginWord, endWord, wordList, vis, res)) {
            res.addFirst(beginWord);
            return res;
        }
        return res;
    }

    private boolean dfs(String beginWord, String endWord, List<String> wordList, boolean[] vis, LinkedList<String> res) {
        if (beginWord.equals(endWord)) return true;
        for (int i = 0; i < wordList.size(); i++) {
            if (vis[i] || !canTansfer(beginWord, wordList.get(i))) continue;
            vis[i] = true;
            res.add(wordList.get(i));
            if (dfs(wordList.get(i), endWord, wordList, vis, res)) return true;
            res.removeLast();
        }
        return false;
    }

    private boolean canTansfer(String beginWord, String to) {
        if (beginWord.length() != to.length()) return false;
        int count = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != to.charAt(i)) count++;
            if (count > 1) break;
        }
        return count == 1;
    }
}
