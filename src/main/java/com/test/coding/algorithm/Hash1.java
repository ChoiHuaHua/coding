package com.test.coding.algorithm;

import java.util.HashMap;

/**
 * 프로그래머스
 * 알고리즘 > 해시
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Hash1 {
    public static void main(String[] args) {

        Hash1 hash1 = new Hash1();
        String result = hash1.solution(new String[]{"leo", "kiki", "eden" }, new String[]{"eden", "kiki"});
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : participant) {
            //hashMap.put(s, hashMap.containsKey(s) ? hashMap.get(s) + 1 : 1);
            hashMap.put(s, hashMap.getOrDefault(s,0) + 1);
        }

        for (String s : completion) {
            hashMap.put(s, hashMap.get(s) - 1);
        }

        answer = hashMap.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();
        return answer;
    }
}
