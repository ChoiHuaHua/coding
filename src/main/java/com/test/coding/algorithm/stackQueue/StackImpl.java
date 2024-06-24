package com.test.coding.algorithm.stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 백준
 * 알고리즘 > 자료구조 > 스택
 * https://www.acmicpc.net/problem/10828
 */
public class StackImpl {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(); //시간 초과 문제 해결

        Scanner sc = new Scanner(System.in);
        int idx = sc.nextInt();
        for (int i = 0; i <= idx; i++) {
            String[] strArr = sc.nextLine().split(" ");
            switch (strArr[0]) {
                case "push":
                    stack.push(Integer.parseInt(strArr[1]));
                    break;
                case "pop":
                    sb.append((stack.empty() ? -1 : stack.pop())+"\n");
                    break;
                case "size":
                    sb.append((stack.size())+"\n");
                    break;
                case "empty":
                    sb.append((stack.empty() ? 1 : 0)+"\n");
                    break;
                case "top":
                    sb.append((stack.empty() ? -1 : stack.peek())+"\n");
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
