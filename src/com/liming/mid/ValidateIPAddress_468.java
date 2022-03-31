package com.liming.mid;

/**
 * @author ltf
 * @date 2022-03-28 20:01
 */
public class ValidateIPAddress_468 {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            if (queryIP.chars().filter(c -> c == '.').count() != 3) {
                return "Neither";
            }

            String[] split = queryIP.split("\\.");
            if (split.length != 4) {
                return "Neither";
            }
            boolean flag = false;
            for (String s : split) {
                if (flag) break;
                if (!isIpv4(s)) {
                    flag = true;
                }
            }
            if (flag) {
                return "Neither";
            } else {
                return "IPv4";
            }
        } else if (queryIP.contains(":")) {
            if (queryIP.chars().filter(c -> c == ':').count() != 7) {
                return "Neither";
            }
            return validateIPv6(queryIP);
        }
        return "Neither";
    }

    public static void main(String[] args) {
        new ValidateIPAddress_468().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }

    private boolean isIpv4(String str) {
        if (str == null || str.length() > 3 || str.length() == 0) return false;
        //前导0
        if (str.charAt(0) == '0' && str.length() > 1) return false;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
            num = num * 10 + (str.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            if (x.length() == 0 || x.length() > 4) return "Neither";
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }
}
