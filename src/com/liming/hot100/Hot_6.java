package com.liming.hot100;

import java.util.regex.Pattern;

/**
 * @author ltf
 * @date 2022-02-01 18:01
 */
public class Hot_6 {
    public boolean isMatch(String s, String p) {
        Pattern pattern= Pattern.compile(p);
        return pattern.matcher(s).matches();
    }
}
