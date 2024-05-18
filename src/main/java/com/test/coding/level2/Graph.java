package com.test.coding.level2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 프로그래머스
 * 2024 KAKAO WINTER INTERNSHIP / 도넛과 막대 그래프
 * https://school.programmers.co.kr/learn/courses/30/lessons/258711
 */
public class Graph {
    public static void main(String[] args) {
        Graph cls = new Graph();
        cls.solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}});
        //cls.solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}});
    }

    public int[] solution(int[][] edges) {
        int[] answer = new int[]{0, 0, 0, 0};
        // 구조 변경 {점점:[간선리스트]}
        Map<Integer, List<Integer>> vertexMap = new HashMap<>();
        // 시작 정점 찾기위해 out 정점만 set
        Set<Integer> outSet = new HashSet<>();
        for (int[] edge : edges) {
            if (vertexMap.containsKey(edge[0])) {
                vertexMap.get(edge[0]).add(edge[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                vertexMap.put(edge[0], list);
            }
            outSet.add(edge[1]);
        }

        // 최초 시작 정점 찾기
        int startVertex = vertexMap.entrySet().stream()
                .filter(v -> !outSet.contains(v.getKey()))
                .max(Comparator.comparingInt(e -> e.getValue().size()))
                .get()
                .getKey();
        answer[0] = startVertex;

        // 차트 구하기
        vertexMap.get(startVertex).forEach(v -> {
            // 정점리스트
            List<Integer> vertexList = new ArrayList<>();
            //간선
            AtomicInteger edgeCnt = new AtomicInteger(0);

            // 시작 정점 넣기
            vertexList.add(v);

            if (vertexMap.get(v) != null) {
                // 간선 더하기
                edgeCnt.addAndGet(vertexMap.get(v).size());

                List<Integer> nextVertex = vertexMap.get(v);
                while (nextVertex.size() > 0) {
                    // 도넛차트 & 8자차트 종료조건
                    if (nextVertex.contains(v)) {
                        break;
                    }

                    List<Integer> newNextVertex = new ArrayList<>();
                    nextVertex.forEach(i -> {
                        vertexList.add(i);
                        if (vertexMap.get(i) != null) {
                            newNextVertex.addAll(vertexMap.get(i));
                            edgeCnt.addAndGet(vertexMap.get(i).size());
                        }
                    });
                    nextVertex = newNextVertex;
                }
            }

            int vertex = vertexList.size();
            if (vertex == edgeCnt.get()) { // 도넛 차트
                answer[1] = answer[1] + 1;
            } else if (vertex == edgeCnt.get() + 1) { // 막대차트
                answer[2] = answer[2] + 1;
            } else if (vertex == edgeCnt.get() - 1) { // 8자차트
                answer[3] = answer[3] + 1;
            }
        });
        return answer;
    }
}
