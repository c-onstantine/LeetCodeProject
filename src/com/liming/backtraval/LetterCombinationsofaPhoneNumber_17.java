package com.liming.backtraval;

import java.util.*;

/**
 * @author ltf
 * @date 2021-08-18 11:43
 * 17. 电话号码的字母组合
 */
public class LetterCombinationsofaPhoneNumber_17 {
    private Map<Character, String> map = new HashMap<>();
    private List<String> res = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return res;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        back(digits, 0);
        return res;
    }

    private void back(String digits, int deep) {
        if (deep == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(deep);
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            back(digits, deep + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
