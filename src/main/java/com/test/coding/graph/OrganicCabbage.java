package com.test.coding.graph;

import java.util.Scanner;

public class OrganicCabbage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int str = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < str; i++) {
            String field = sc.nextLine();
            String[] fieldArr = field.split(" ");

            int h = Integer.parseInt(fieldArr[0]); //가로
            int v = Integer.parseInt(fieldArr[1]); //세로
            int cnt = Integer.parseInt(fieldArr[2]);

            int[][] array = new int[v][h];
            for (int j = 0; j < cnt; j++) {
                String[] loc = sc.nextLine().split(" ");
                int y = Integer.parseInt(loc[1]); //가로
                int x = Integer.parseInt(loc[0]); //세로
                array[y][x] = 1;
            }

            OrganicCabbage organicCabbage = new OrganicCabbage();
            int count = 0;
            for (int y = 0; y < v; y++) {
                for (int x = 0; x < h; x++) {
                    if (array[y][x] == 1) {
                        count ++;
                        organicCabbage.findCabbage(array, y, x);
                    }
                }
            }
            System.out.println(count);
        }
    }

    public void findCabbage(int[][] array, int y, int x) {
        array[y][x] = 0;
        if (y + 1 < array.length && array[y + 1][x] == 1) {
            findCabbage(array, y + 1, x);
        }
        if (y - 1 >= 0 && array[y - 1][x] == 1) {
            findCabbage(array, y - 1, x);
        }
        if (x + 1 < array[0].length && array[y][x + 1] == 1) {
            findCabbage(array, y, x + 1);
        }
        if (x - 1 >= 0 && array[y][x - 1] == 1) {
            findCabbage(array, y, x - 1);
        }
    }
}
