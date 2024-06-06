package com.test.coding.algorithm.stackQueue;

import java.util.Stack;

public class StackQueue1 {
    public static void main(String[] args) {
        StackQueue1 cls = new StackQueue1();
        cls.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
    }

    public int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (stack.peek() != i) {
                stack.push(i);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}