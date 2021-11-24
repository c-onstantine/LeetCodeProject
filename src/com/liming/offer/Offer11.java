package com.liming.offer;

/**
 * @author ltf
 * @date 2021-02-24 14:59
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        int indexmid = index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexmid = index2;
                break;
            }
            indexmid = (index1 + index2) / 2;
            if (numbers[index1] == numbers[index2] && numbers[index1] == numbers[indexmid]) {
                int res = numbers[index1];
                for (int i = index1 + 1; i <= index2; i++) {
                    if (res > numbers[i]) {
                        res = numbers[i];
                    }

                }
                return res;
            }
            if (numbers[indexmid] >= numbers[index1]) {
                index1 = indexmid;
            } else if (numbers[indexmid] <= numbers[index2]) {
                index2 = indexmid;
            }
        }
        return numbers[indexmid];
    }
}
