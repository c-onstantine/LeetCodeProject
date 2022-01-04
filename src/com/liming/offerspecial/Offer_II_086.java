package com.liming.offerspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2022-01-04 20:00
 */
public class Offer_II_086 {
    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    public String[][] partition(String s) {
        backTracking(s, 0);
        String[][] result = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = new String[res.get(i).size()];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = res.get(i).get(j);
            }
        }
        return result;
    }

    private void backTracking(String s, int start) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i + 1));
            } else {
                continue;
            }
            backTracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Offer_II_086().partition("google");
    }
}
