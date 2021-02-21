package com.example.learningnote.matrix;

/**
 * 绕圈打印矩阵
 * 例如 4*4 矩阵
 * 1    2   3   4
 * 5    6   7   8
 * 9    10  11  12
 * 13   14  15  16
 *
 * 打印 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 */
public class PrintMatrixSpiralOrder {

    public static void main(String[] args) {
        int row = 4, col = 4;
        int num = 1;
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = num++;
            }
        }

        int tR = 0, tC = 0, bR = arr.length - 1, bC = arr[0].length - 1;
        while (tR <= bR && tC <= bC) {
            printSubArr(arr, tR++, tC++, bR--, bC--);
        }
        System.out.println();
        tR = 0;
        tC = 0;
        bR = arr.length - 1;
        bC = arr[0].length - 1;
        while (tR <= bR && tC <= bC) {
            printEdge(arr, tR++, tC++, bR--, bC--);
        }


    }

    public static void printSubArr(int[][] arr, int tR, int tC, int bR, int bC) {

        if (tR==tC && tC==bR && bR==bC){
            System.out.print(arr[tR][tC] + " ");
            return;
        }

        int r = tR, c = tC;
        while (c != bC) {//step 1
            System.out.print(arr[tR][c] + " ");
            c++;
        }
        while (r != bR) {//step 2
            System.out.print(arr[r][bC] + " ");
            r++;
        }

        if (bR != tR) { //step 3 避免重复打印同一行的情况,step1已经横向打印完结果
            while (c != tC) {
                System.out.print(arr[bR][c] + " ");
                c--;
            }
        }

        if (bC != tC){//step 4 避免重复打印同一列的情况,step2已经纵向打印完结果
            while (r != tR) {
                System.out.print(arr[r][tC] + " ");
                r--;
            }
        }

    }

    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }


}
