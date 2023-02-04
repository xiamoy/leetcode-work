package com.example.leetcode.hot100;

public class LeetCode_L240_Searcha2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean b = searchMatrix(matrix, 5);
        System.out.println(b);

        int[][] matrix2 = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean b1 = searchMatrix(matrix2, 20);
        System.out.println(b1);
    }

    //13ms,57.9MB
    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = m - 1; i >= 0; i--) {
            int left = 0, right = n - 1;
            if (matrix[i][n - 1] < target) {
                break;
            }
            if (matrix[i][0] > target) {
                continue;
            }

            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return false;

    }

    //11ms,58.2MB
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int curRow = 0, curCol = n - 1;
        while (curRow < m && curCol >= 0) {
            if (matrix[curRow][curCol] == target) {
                return true;
            } else if (matrix[curRow][curCol] > target) {
                curCol--;
            } else {
                curRow++;
            }
        }

        return false;
    }

    //5ms,48.7MB
    public static boolean searchMatrix3(int[][] matrix, int target) {
        int rBegin = 0, cBegin = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int curRow = m - 1, curCol = 0;
        while (curRow >= 0 && curCol < n) {
            if (matrix[curRow][curCol] == target) {
                return true;
            } else if (matrix[curRow][curCol] > target) {
                curRow--;
            } else {
                curCol++;
            }
        }

        return false;
    }

}
