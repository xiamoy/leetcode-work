package com.example.leetcode.hot100;

import java.util.Arrays;

public class LeetCode_L56_MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
        System.out.println(merge);

//        int[][] intervals={{1,4},{0,0}};
//        int[][] merge = merge(intervals);
//        System.out.println(merge);// [{1,4},{0,0}]

    }

    //8ms, 47.2MB
    public int[][] merge2(int[][] intervals) {
        int row = intervals.length;
        int col = intervals[0].length;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int[][] res = new int[row][col];
        res[0] = intervals[0];
        int i = 1;
        int index = i;
        for (; i < row; i++) {
            int[] cur = intervals[i];
            int[] prev = res[index - 1];
            if (cur[0] > prev[1]) {
                res[index++] = cur;
            } else {
                prev[1] = Math.max(prev[1], cur[1]);
            }
        }
        return Arrays.copyOf(res, index);
    }


    //21ms, 54.8MB
    public static int[][] merge(int[][] intervals) {
        int row = intervals.length;
        int col = intervals[0].length;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        if (!hasInterval(intervals)) {
            return intervals;
        }

        int[][] result = new int[row][col];

        result[0] = intervals[0];
        int begin = 1, i = 0;
        while (begin < row) {
            int[] cur = intervals[begin];
            int[] prev = result[i];
            if (prev[col - 1] < cur[0]) {
                result[++i] = cur;
            } else {
                result[i][0] = Math.min(cur[0], prev[0]);
                result[i][col - 1] = Math.max(cur[col - 1], prev[col - 1]);
            }
            begin++;
        }

        int[][] next = Arrays.copyOf(result, i + 1);

        return next;
    }


    public static boolean hasInterval(int[][] intervals) {
        int row = intervals.length;
        if (row <= 1) {
            return false;
        }
        int len = intervals[0].length;
        for (int i = 0; i < row - 1; i++) {
            int[] cur = intervals[i];
            int[] next = intervals[i + 1];

            if (!(cur[len - 1] < next[0])) {
                return true;
            }
        }
        return false;
    }
}
