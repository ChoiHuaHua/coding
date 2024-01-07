package com.test.coding.level1;

import java.util.*;

/**
 * 프로그래머스
 * 가장 많이 받은 선물
 * https://school.programmers.co.kr/learn/courses/30/lessons/258712
 */
public class MostReceivedGift {
    public static void main(String[] args) {
        MostReceivedGift cls = new MostReceivedGift();
        cls.solution(new String[]{"joy", "brad", "alessandro", "conan", "david"}, new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"});
    }

    public int solution(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> giftResult = new HashMap<>();
        Arrays.stream(friends).forEach(name -> {
            Map<String, Integer> friendMap = new HashMap<>();
            Arrays.stream(friends).filter(friendName -> !name.equals(friendName)).forEach(friendName -> friendMap.put(friendName, 0));
            friendMap.put("toCnt", 0);
            friendMap.put("fromCnt", 0);
            friendMap.put("result", 0);
            giftResult.put(name, friendMap);
        });

        Arrays.stream(gifts).forEach(s -> {
            String[] arr = s.split(" ");
            String to = arr[0];
            String from = arr[1];
            giftResult.get(to).put(from, giftResult.get(to).get(from) + 1);
            giftResult.get(to).put("toCnt", giftResult.get(to).get("toCnt") + 1);
            giftResult.get(from).put("fromCnt", giftResult.get(from).get("fromCnt") + 1);
        });

        Arrays.stream(friends).forEach(name -> {
            giftResult.get(name).entrySet().stream().forEach(friendMap -> {
                if (giftResult.containsKey(friendMap.getKey())) {
                    if (friendMap.getValue() > giftResult.get(friendMap.getKey()).get(name)) {
                        giftResult.get(name).put("result", giftResult.get(name).get("result") + 1);
                    } else if (friendMap.getValue() == giftResult.get(friendMap.getKey()).get(name)) {
                        int nameCnt = giftResult.get(name).get("toCnt") - giftResult.get(name).get("fromCnt");
                        int friendCnt = giftResult.get(friendMap.getKey()).get("toCnt") - giftResult.get(friendMap.getKey()).get("fromCnt");
                        if (nameCnt > friendCnt) {
                            giftResult.get(name).put("result", giftResult.get(name).get("result") + 1);
                        }
                    }
                }
            });
        });
        return giftResult.entrySet().stream().map(Map.Entry::getValue).max(Comparator.comparing(map -> map.get("result"))).get().get("result");
    }
}
