package com.liming.qiuzhao.codetop.yama;

import java.util.*;

/**
 * @author ltf
 * @date 2022-09-04 9:52
 */
public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) {
            return 0;
        }

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        Set<String> vis = new HashSet<>();
        vis.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if(canChangeLetter(poll,endWord,queue,vis,wordSet)){
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private boolean canChangeLetter(String currentWord, String endWord, Deque<String> queue, Set<String> vis, Set<String> wordSet) {
        char[] letters = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char old = letters[i];
            for(int j = 'a'; j <= 'z'; j++){
                if(old == j){
                    continue;
                }
                letters[i] = (char) j;
                String tmp = String.valueOf(letters);
                if(wordSet.contains(tmp)){
                    if(tmp.equals(endWord)){
                        return true;
                    }
                    if(!vis.contains(tmp)){
                        queue.offer(tmp);
                        vis.add(tmp);
                    }
                }
            }
            letters[i] = old;
        }
        return false;
    }

}
