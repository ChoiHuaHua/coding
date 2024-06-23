package com.test.coding.algorithm.stackQueue;

import java.util.Stack;

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