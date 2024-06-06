package com.test.coding.algorithm.hash;

import java.util.HashSet;
import java.util.List;


/**
 * 프로그래머스
 * 알고리즘 > 해시
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Hash3 {

    public static void main(String[] args) {

        Hash3 hash3 = new Hash3();
        Boolean result = hash3.solution(new String[]{"123","456","123789"});
        System.out.println("result = " + result);
    }

    public Boolean solution(String[] phone_book) {
        boolean answer = true;

        HashSet<String> hashSet = new HashSet<>(List.of(phone_book));
        for (String s: hashSet){
            for (int i = 1; i < s.length(); i++){
                if (hashSet.contains(s.substring(0, i))){
                    return false;
                }
            }
        }
        return answer;
    }
}
