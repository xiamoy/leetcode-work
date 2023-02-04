package com.example.leetcode;

public class LeetCode_L59_SpiralMatrixII {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        printArr(ints);
        System.out.println();
        printArr(generateMatrix(2));

    }

    //0ms,42.1MB
    public static void printArr(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            String s = "";
            for (int j = 0; j < m[0].length; j++) {
                s += m[i][j] + ",";
            }
            s = s.substring(0, s.length() - 1);
            System.out.println(s);
        }

    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;

        int layer = 0;
        for (int i = 0; i < n - layer; ) {
            int j = i;
            if (j == n - 1 - layer) {
                matrix[i][j] = num;
                break;
            }
            for (; j < n - 1 - layer; j++) {
                matrix[i][j] = num++;
            }
            int k = i;
            for (; k < n - 1 - layer; k++) {
                matrix[k][j] = num++;
            }
            int m = k;
            for (; m > layer; m--) {
                matrix[j][m] = num++;
            }
            int r = k;
            for (; r > i; r--) {
                matrix[r][m] = num++;
            }
            layer++;
            i++;

        }
        return matrix;
    }

}
