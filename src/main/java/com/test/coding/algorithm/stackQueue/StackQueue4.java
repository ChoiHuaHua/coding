package com.test.coding.algorithm.stackQueue;

import java.util.*;

public class StackQueue4 {
    public static void main(String[] args) {
        StackQueue4 cls = new StackQueue4();
        cls.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> rankQueue = new LinkedList<>();
        Queue<Integer> locQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            rankQueue.add(priorities[i]);
            locQueue.add(i);
        }

        while (!rankQueue.isEmpty()) {
            int max = Collections.max(rankQueue);
            int rank = rankQueue.poll();
            int loc = locQueue.poll();

            if (rank == max) {
                answer++;
                if (loc == location) {
                    break;
                }
            } else {
                rankQueue.add(rank);
                locQueue.add(loc);
            }
        }
        return answer;
    }
}