package com.liming.backtraval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-19 17:52
 * 93. 复原 IP 地址
 */
public class RestoreIPAddresses_93 {
    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        back(new StringBuilder(s), 0, 0);
        return res;
    }

    private void back(StringBuilder sb, int start, int num) {
        if (num == 3) {
            if (isRight(sb.toString(), start, sb.length() - 1)) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = start; i < sb.length(); i++) {
            if (isRight(sb.toString(), start, i)) {
                num++;
                sb.insert(i + 1, ".");
                back(sb, i + 2, num);
                num--;
                sb.deleteCharAt(i + 1);
            }
        }
    }

    private boolean isRight(String s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') return false;
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) return false;
        }
        return true;
    }
}
