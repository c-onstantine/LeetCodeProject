package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-04-14 16:03
 */
public class Face0101 {
    public boolean isUnique(String astr) {
        int mark = 0;
        int len = astr.length();
        int mov = 0;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            char c = astr.charAt(i);
            mov = c - 'a';
            tmp = 1 << mov;
            if ((mark & tmp) != 0) {
                return false;
            } else {
                mark |= tmp;
            }
        }
        return true;
    }
}
