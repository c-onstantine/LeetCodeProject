package com.liming.pdd;

import java.util.*;

/**
 * @author ltf
 * @date 2022-04-10 18:52
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                List<Integer> list = map.get(arr[i]);
                list.add(i);
                map.put(arr[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
        List<int[]> res = new ArrayList<>();
        for (int i : map.keySet()) {
            List<Integer> list = map.get(i);
            if (list.size() == 1) {
                res.add(new int[]{i, 0});
            } else {
                int diff = list.get(1) - list.get(0);
                boolean flag = false;
                for (int j = 2; j < list.size(); j++) {
                    if (list.get(j) - list.get(j - 1) != diff) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    res.add(new int[]{i, diff});
                }
            }
        }
        System.out.println(res.size());
        Collections.sort(res, (x, y) -> x[0] - y[0]);
        for (int[] r : res) {
            System.out.println(r[0] + " " + r[1]);
        }
    }

    //        if (n == 1) {
    //    System.out.println(1);
    //    System.out.println(arr[0] + " " + 0);
    //} else {
    //    Map<Integer, int[]> map = new HashMap<>();
    //    for (int i = 0; i < arr.length; i++) {
    //        if (map.containsKey(arr[i])) {
    //            int[] ints = map.get(arr[i]);
    //            if (ints[2] == 2) continue;
    //            int tmp = i - ints[0];
    //            map.remove(arr[i]);
    //            if (tmp == ints[1] || ints[2] == 0) {
    //                map.put(arr[i], new int[]{i, tmp, 1});
    //            } else {
    //                map.put(arr[i], new int[]{i, tmp, 2});
    //            }
    //        } else {
    //            map.put(arr[i], new int[]{i, 0, 0});
    //        }
    //    }
    //    int count = 0;
    //    for (int i : map.keySet()) {
    //        if (map.get(i)[2] != 2) {
    //            count++;
    //        }
    //    }
    //    System.out.println(count);
    //    for (int i : map.keySet()) {
    //        if (map.get(i)[2] != 2) {
    //            System.out.println(i + " " + map.get(i)[1]);
    //        }
    //    }
    //}
}
