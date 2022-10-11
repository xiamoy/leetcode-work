package com.example.leetcode.stringtag;




public class LeetCode_L6_ZigZag {

    public static void main(String[] args) {

        System.out.println(zigZagConvert("PAYPALISHIRING",3));
    }


    public static String zigZagConvert(String s,int numRows) {
       int row = numRows,column =0;
        int[][] arr=new int[row][column];
        int iRow=0,iColumn=0;

        for (int j = 0; j < s.length(); ) {
            arr[iRow++][0] = s.charAt(j++);
        }
        //TODO
        return null;

    }


}
