package com.example;

public class SelfArrayUtils {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void printArr2(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            String str="";
            for (int j = 0; j < arr[0].length; j++) {
                str+= arr[i][j] + ",";
            }

            str = str.substring(0,str.lastIndexOf(","));
            System.out.println(str);

        }
    }

    public static int[] generateArr(int sizeFrom,int sizeEnd, int minVal, int maxVal) {
        int size = sizeEnd-sizeFrom;
        int x = (int) (Math.random() * (size + 1)) + sizeFrom;
        int[] arr = new int[x];
        for (int i = 0; i < x; i++) {
            arr[i] = (int) (Math.random() * (maxVal - minVal + 1)) + minVal;
        }
        return arr;
    }
}
