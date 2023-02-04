package com.example.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_L406_QueueReconstructionbyHeight {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        int[][] ints = reconstructQueue(people);
        System.out.println(ints);
    }

    public static int[][] reconstructQueue(int[][] people) {
//        int[][] res=new int[people.length][people[0].length];
        List<int[]> list = new ArrayList<>(people.length);
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        for (int[] item : people) {
            list.add(item[1], item);
        }
        int[][] res = list.toArray(new int[][]{});
        return res;
    }
}
