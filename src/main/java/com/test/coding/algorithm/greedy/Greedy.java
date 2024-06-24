package com.test.coding.algorithm.greedy;

import java.util.*;
/**
 * 백준
 * 알고리즘 > 그리디알고리즘
 * https://www.acmicpc.net/problem/1511
 */
public class Greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < strArr.length; i++) {
            if (!"0".equals(strArr[i])) {
                map.put(i, Integer.valueOf(strArr[i]));
            }
        }

        String answer = "";
        int lastVal = 0;
        while (true) {
            Integer key = null;
            Integer maxCntKey = null;

            int totCnt = 0;
            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                totCnt += m.getValue();
            }

            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                if(m.getValue() > 0 && lastVal != m.getKey()){
                    if(m.getValue() > totCnt - m.getValue()){
                        maxCntKey = m.getKey();
                        break;
                    }
                    key = m.getKey();
                }
            }
            if (maxCntKey == null && key == null) {
                break;
            }
            lastVal = maxCntKey != null ? maxCntKey : key;
            answer += String.valueOf(lastVal);
            map.put(lastVal, map.get(lastVal) - 1);
        }
        System.out.println("".equals(answer) ? "0" : answer);
    }
}
