package com.liming.offerspecial;

import java.util.*;

/**
 * @author ltf
 * @date 2022-01-11 10:12
 */
public class Offer_II_108 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visset = new HashSet<>(wordList);
        if(!visset.contains(endWord)){
            return 0;
        }
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int len =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                visset.remove(poll);
                if(endWord.equals(poll)){
                    return len;
                }
                getNeighbor(visset,new StringBuilder(poll),queue);
            }
        }
        return 0;
    }

    private void getNeighbor(Set<String> visset, StringBuilder sb, Deque<String> queue) {
        for (int i = 0; i < sb.length(); i++) {
            char tmp = sb.charAt(i);
            for (char j = 'a'; j <= 'z'; j++){
                sb.deleteCharAt(i);
                sb.insert(i,j);
                if(j!=tmp && visset.contains(sb.toString())){
                    queue.offer(sb.toString());
                }
            }
            sb.deleteCharAt(i);
            sb.insert(i,tmp);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        new Offer_II_108().ladderLength("hit","cog",list);
    }
}
