package com.example.leetcode.day02;

public class MultiplyStrings {

    public static void main(String[] args) {

//        String i = new Solution2().multiply("123456789","987654321"); //"121932631112635269"
//        System.out.println(i);
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) return mid;
            else if (sqrt < mid) h = mid - 1;
            else l = mid + 1;
        }
        return h;
    }
}

class Solution2 {
    public String multiply(String num1, String num2) {
        String res = "";
        return null;

    }


}
