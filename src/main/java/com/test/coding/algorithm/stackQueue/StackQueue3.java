package com.test.coding.algorithm.stackQueue;

import java.util.Stack;
/**
 * 프로그래머스
 * 알고리즘 > 스택/큐
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class StackQueue3 {
    public static void main(String[] args) {
        StackQueue3 cls = new StackQueue3();
        cls.solution("(()(");
    }

    public boolean solution(String s) {
        boolean answer = true;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(1);
            } else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            answer = false;
        }
        return answer;
    }
}