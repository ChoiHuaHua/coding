package com.test.coding.algorithm;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 백준
 * 알고리즘 > 자료구조 > 괄호
 * https://www.acmicpc.net/problem/9012
 */
public class ParenthesisString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if(str.contains("(") || str.contains(")")){
                String result = solution(str);
                System.out.println("result = " + result);
            }
        }

    }

    public static String solution(String ps) {
        String result = "YES";
        List<Character> list1 = new ArrayList<>();
        for (int i = 0; i < ps.length(); i++) {
            if ('(' == ps.charAt(i)) {
                list1.add(ps.charAt(i));
            } else if (')' == ps.charAt(i)) {
                if (list1.size() == 0) {
                    return "NO";
                }
                list1.remove(list1.size() - 1);
            }
        }
        if (list1.size() > 0) {
            result = "NO";
        }
        return result;
    }
}
