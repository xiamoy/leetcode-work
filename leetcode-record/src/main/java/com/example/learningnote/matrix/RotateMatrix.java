package com.example.learningnote.matrix;

import com.example.SelfArrayUtils;

/**
 * 旋转正方形 90°
 * <p>
 * 例如 4*4 矩阵
 * 1    2   3   4
 * 5    6   7   8
 * 9    10  11  12
 * 13   14  15  16
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int row = 4, col = row;
        int num = 1;
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = num++;
            }
        }
        SelfArrayUtils.printArr2(arr);

        int tR = 0, tC = 0, bR = arr.length - 1, bC = arr[0].length - 1;
        while (tR<=bR){
            roataeSubMatrix(arr,tR++,tC++,bR--,bC--);
        }

        System.out.println("rotated array....");
        SelfArrayUtils.printArr2(arr);
    }

    public static void roataeSubMatrix(int[][] arr, int tR, int tC, int bR, int bC) {

        for (int i = 0; i +tC!= bC; i++) {
            int temp =arr[tR][tC+i];
            arr[tR][tC+i] = arr[bR-i][tC];
            arr[bR-i][tC] = arr[bR][bC-i];
            arr[bR][bC-i] = arr[tR+i][bC];
            arr[tR+i][bC] = temp;
        }
    }
}
