package com.test.coding.level1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 프로그래머스
 * [PCCE 기출문제] 10번 / 데이터 분석
 * https://school.programmers.co.kr/learn/courses/30/lessons/250121
 * */
public class DataAnalysis {
    public static void main(String[] args) {

        int [][] test = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        solution(test,"date",20300501,"remain");
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] arr = {"code", "date", "maximum", "remain"};

        int extIdx = Arrays.asList(arr).indexOf(ext);
        int sortIdx = Arrays.asList(arr).indexOf(sort_by);

        int [][] answer = Arrays.stream(data).filter(d -> d[extIdx] < val_ext).sorted(Comparator.comparingInt(i -> i[sortIdx])).toArray(int[][]::new);

        return answer;
    }
}
