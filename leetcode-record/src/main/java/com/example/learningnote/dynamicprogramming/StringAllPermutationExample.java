package com.example.learningnote.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class StringAllPermutationExample {
    public static void main(String[] args) {
        String value = "abc";
        listPermutationWithoutDuplicates(value.toCharArray(), 0);

//        permutation(value.toCharArray(),0,value.length());
    }


    public static void listPermutationWithoutDuplicates(char[] chars, int from) {
        if (from == chars.length) {
            System.out.println(String.valueOf(chars));
            return;
        }

//        Set<Character> set = new HashSet<>();

        for (int i = from; i < chars.length; i++) {
//            if (!set.contains(chars[i])) {
//                set.add(chars[i]);
            swap(chars, from, i);
            listPermutationWithoutDuplicates(chars, from + 1);
            swap(chars, from, i);
//            }

        }

    }

    public static void listPermutationWithDuplicates(char[] chars, int from) {
        if (from == chars.length) {
            System.out.println(String.valueOf(chars));
            return;
        }

        Set<Character> set = new HashSet<>();

        for (int i = from; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                swap(chars, from, i);
                listPermutationWithDuplicates(chars, from + 1);
                swap(chars, from, i);
            }

        }

    }

    public static void swap(char[] chars, int from, int to) {
        char tmpFrom = chars[from];
//        char tmpTo = chars[to];
        chars[from] = chars[to];
        chars[to] = tmpFrom;
    }

    public static void permutation(char a[], int m, int n) {
        int i;
        char t;
        if (m < n - 1) {
            permutation(a, m + 1, n);
            for (i = m + 1; i < n; i++) {
                t = a[m];
                a[m] = a[i];
                a[i] = t;
                permutation(a, m + 1, n);
                t = a[m];
                a[m] = a[i];
                a[i] = t;
            }
        } else {
            printResult(a);
        }
    }

    /**
     * 输出指定字符数组
     *
     * @param text 将要输出的字符数组
     */
    public static void printResult(char[] text) {
        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i]);
        }
        System.out.println();
    }
}
