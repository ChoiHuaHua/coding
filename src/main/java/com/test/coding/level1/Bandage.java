package com.test.coding.level1;

/**
 * 프로그래머스
 * [PCCP 기출문제] 1번 / 붕대 감기
 * https://school.programmers.co.kr/learn/courses/30/lessons/250137
 */
public class Bandage {
    public static void main(String[] args) {
        Bandage cls = new Bandage();
        int result = cls.solution(new int[]{5, 1, 5 }, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}});
        //int result = cls.solution(new int[]{1, 1, 1 }, 5, new int[][]{{1, 2}, {3, 2}});
        System.out.println(result);
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int attacksTime = attacks[attacks.length - 1][0]; //공격시간
        int bandageCombo = bandage[0]; //연속 회복 콤보
        int rcvyAmt = bandage[1]; //회복량
        int addRcvyAmt = bandage[2]; //추가 회복량

        int combo = 0;
        for (int i = 1; i <= attacksTime; i++) {
            boolean isAttacked = false;
            int recovery = 0;

            for (int j = 0; j < attacks.length; j++) {
                if (i == attacks[j][0]) {
                    isAttacked = true;
                    combo = 0;

                    health -= attacks[j][1];

                    if (health <= 0) {
                        return -1;
                    }
                }
            }

            if(!isAttacked){
                combo++;
                recovery += rcvyAmt;
                if (combo == bandageCombo) {
                    recovery += addRcvyAmt;
                    combo = 0;
                }
                health += recovery <= (maxHealth - health) ? recovery : (maxHealth - health);
            }
        }
        return health;
    }
}
