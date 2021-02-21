package com.example.learningnote.matrix;

/**
 * 按之字形打印矩阵
 *
 * 例如 4*4 矩阵
 * 1    2   3   4
 * 5    6   7   8
 * 9    10  11  12
 * 13   14  15  16
 *
 * expected: 1 2 5 9 6 3 4 7 10 13 14 11 8 12 15 16
 */
public class ZigZagMatrix {

    public static void main(String[] args) {
        int row = 4, col = 4;
        int num = 1;
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = num++;
            }
        }

        int tR = 0, tC = 0, bR = 0, bC = 0;
        boolean isUp = true;
        while (tR <= row - 1) {

            printEdge(arr, tR, tC++, bR++, bC, isUp);
            if (tC > col - 1) {
                tC = col-1;
                tR++;
            }
            if (bR > row - 1) {
                bR = row-1;
                bC++;
            }
            isUp = !isUp;
        }

    }

    public static void printEdge(int[][] arr, int tR, int tC, int bR, int bC, boolean isUp) {
        if (isUp) { // 斜右上方打印
            while (bR >= tR ) {
                System.out.print(arr[bR--][bC++] + " ");
            }
        } else {// 斜左下方打印
            while (tR <= bR ) {
                System.out.print(arr[tR++][tC--] + " ");
            }
        }
    }
}
