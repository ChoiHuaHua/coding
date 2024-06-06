package com.test.coding.algorithm.stackQueue;

import java.util.*;

public class StackQueue2 {
    public static void main(String[] args) {
        StackQueue2 cls = new StackQueue2();
        cls.solution(new int[]{96, 94}, new int[]{3, 3});
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> result = new LinkedList<>();

        Queue<Integer> dayQueue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            dayQueue.add((int) Math.ceil((100 - (double) progresses[i]) / (double) speeds[i]));
        }
        int buildCnt = 1;
        int MaxDay = dayQueue.poll();
        while (true) {
            if (dayQueue.isEmpty()) {
                result.add(buildCnt);
                break;
            }
            int day = dayQueue.poll();
            if (MaxDay >= day) {
                buildCnt++;
            } else {
                result.add(buildCnt);
                buildCnt = 1;
                MaxDay = day;
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.poll();
        }
        return answer;
    }
}