package com.test.coding.algorithm;

import java.util.HashSet;

/**
 * 프로그래머스
 * 알고리즘 > 해시
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Hash2 {

    public static void main(String[] args) {

        Hash2 hash2 = new Hash2();
        int result = hash2.solution(new int[]{3,1,2,3});
        System.out.println("result = " + result);
    }

    public int solution(int[] nums) {
        int getNum = nums.length / 2;

        HashSet hashSet = new HashSet();
        for (int num: nums){
            hashSet.add(num);
        }

        return Math.min(getNum, hashSet.size());
    }
}
