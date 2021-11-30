package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-30 20:55
 */
public class Offer_67 {
    public int strToInt(String str) {
        int res = 0, index = 0, sign = 1, bind = Integer.MAX_VALUE / 10;
        if (str == null || str.length() == 0) return 0;
        while (str.charAt(index) == ' ') {
            index++;
            if (index == str.length()) return 0;
        }
        if (str.charAt(index) == '-') sign = -1;
        if (str.charAt(index) == '-' || str.charAt(index) == '+') index++;
        while (index < str.length()) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') break;
            //bndry=2147483647//10=214748364 大于7 则拼接后会溢出
            if (res > bind || (res == bind && str.charAt(index) > '7'))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(index) - '0');
            index++;
        }
        return res * sign;
    }
}
