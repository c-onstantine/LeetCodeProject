package com.liming.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2022-02-03 9:31
 */
public class Hot_9 {
    public List<String> letterCombinations(String digits) {
        String[] strTab = new String[]{
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        backTracking(strTab, digits,new StringBuilder(),res, 0);
        return res;
    }

    private void backTracking(String[] strTab, String digits,StringBuilder sb, List<String> res, int deep) {
        if (digits.length() == deep) {
            res.add(sb.toString());
            return;
        }
        int index = digits.charAt(deep) - '0';
        String str = strTab[index];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(strTab, digits,sb,res, deep + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        new Hot_9().letterCombinations("23");
    }
}
