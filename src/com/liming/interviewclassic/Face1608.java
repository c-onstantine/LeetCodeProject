package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-05-31 20:41
 * 面试题 16.08. 整数的英语表示
 */
public class Face1608 {
    private StringBuilder sb = new StringBuilder();

    public String numberToWords(int num) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90,
                100, 1000, 1000000, 1000000000};
        String[] str = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
                "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",
                "Hundred", "Thousand", "Million", "Billion"};
        if (num == 0) return "Zero";
        deal(num,nums,str);
        return sb.toString();
    }

    private void deal(int num, int[] nums, String[] str) {
        int i = 30;
        while (i >= 0 && nums[i] > num) i--;
        int k = 90;
        if (nums[i] <= k) {
            sb.append(str[i]);
        } else {
            deal(num / nums[i], nums, str);
            sb.append(" " + str[i]);
        }
        if (num % nums[i] > 0) {
            sb.append(" ");
            deal(num % nums[i], nums, str);
        }
    }
}
