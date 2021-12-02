package com.liming.offeragain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-12-02 19:22
 */
public class Offer_38 {
    public String[] permutation(String s) {
        List<String> reslist = new ArrayList<>();
        return null;
    }

    private void dfs(String s, StringBuilder sb, List<String> reslist) {
        if (sb.length() == s.length() - 1) {
            reslist.add(sb.toString());
            return;
        }

    }
}
