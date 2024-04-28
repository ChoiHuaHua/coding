package com.test.coding.algorithm;

import java.util.*;


/**
 * 프로그래머스
 * 알고리즘 > 해시
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */
public class Hash4 {

    public static void main(String[] args) {

        Hash4 hash4 = new Hash4();
        int[] result = hash4.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 150, 2500});
        System.out.println("result = " + result.toString());
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Map<Integer, Integer>> genresMap = new HashMap<>();
        //key: 장르, value: Map(key: 곡번호, value: 재생횟수) 형태로 변환
        for (int i = 0; i < genres.length; i++) {
            if(genresMap.containsKey(genres[i])){
                genresMap.get(genres[i]).put(i, plays[i]);
            }else {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                genresMap.put(genres[i], map);
            }
        }

        List<Integer> result = new ArrayList<>();
        //재생횟수로 처리
        genresMap.entrySet().stream().sorted((o1, o2) -> o2.getValue().values().stream().reduce(0, Integer::sum) - o1.getValue().values().stream().reduce(0, Integer::sum)).forEach(
            o -> {
                // 장르별 재생횟수로 정렬처리 및 2곡만 담기
                Map<Integer, Integer> map = o.getValue();
                map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).limit(2).forEach(m -> {
                    result.add(m.getKey());
                });
            }
        );
        return result.stream().mapToInt(i -> i).toArray();
    }
}
