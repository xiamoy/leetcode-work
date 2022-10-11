package com.example.learningnote.dynamicprogramming;

public class MinPath {
    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};

//        int walk = walk(m, 0, 0); // 21
        int walkDpRes = walkDp(m); // 21
        System.out.println(walkDpRes);

    }

    public static int walk(int[][] marix, int row, int col) {
        int cur = marix[row][col];
        if (row == marix.length - 1 && col == marix[0].length - 1) {
            return cur;
        }
        if (row == marix.length - 1) {
            return cur + walk(marix, row, col + 1);
        }
        if (col == marix[0].length - 1) {
            return cur + walk(marix, row + 1, col);
        }
        int walkRight = cur + walk(marix, row, col + 1);
        int walkDown = cur + walk(marix, row + 1, col);
        return cur + Math.min(walkRight, walkDown);
    }

    public static int walkDp(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];

        int i = matrix.length - 1, j = matrix[0].length - 1;
        int cur = matrix[i][j];
        dp[i][j] = cur;

        for (int col = j - 1; col >= 0; col--) {
            dp[i][col] = dp[i][col + 1]+matrix[i][col];
        }
        for (int row = i - 1; row >= 0; row--) {
            dp[row][j] = dp[row + 1][j]+matrix[row][j];
        }


        for (int x = i - 1; x >= 0; x--) {
            for (int y = j - 1; y >= 0; y--) {
//                dp[x][y] = matrix[x][y];
                dp[x][y] = matrix[x][y] + Math.min(dp[x + 1][y], dp[x][y + 1]);
            }
        }


        return dp[0][0];
    }
}
