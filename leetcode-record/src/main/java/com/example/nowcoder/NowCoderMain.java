package com.example.nowcoder;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NowCoderMain {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = new int[]{2, 2, 3, 4, 3};
//        int maxLength = solution.maxLength2(arr);
//        System.out.println(maxLength);

        System.out.println("======findMedianinTwoSortedAray=========");
        int[] a1 = new int[]{0, 1, 2, 3};
        int[] a2 = new int[]{1, 3, 4, 5};
        System.out.println(solution.findMedianinTwoSortedAray(a1, a2));


    }
}



class Solution {


    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
        Map<Integer,Integer> map=new HashMap<>();
        int[] values=new int[1024];

        int[] res=new int[operators.length];
        int unusedMostOften;
        for(int i=0;i<operators.length;i++){
            int opt=operators[i][0];
            int key=operators[i][1];
            if (opt==1){
                int value=operators[i][2];
                values[key]=value;
            }else{

            }

        }
        return null;

    }



    //TODO
    public int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        int length = arr1.length;

        int index = length % 2 == 0 ? length / 2 : (length / 2 + 1);

        if (arr2[0] >= arr1[length - 1]) {
            return arr1[index];
        }

        int left = 0, right = 0;
        int[] a = new int[2 * length];
        int count = 0;


        while (left < length - 1 && right < length - 1) {
            if (arr1[left] < arr2[right]) {
                a[count++] = arr1[left++];
            } else if (arr1[left] > arr2[right]) {
                a[count++] = arr2[right++];
            } else {
                a[count++] = arr1[left++];
                a[count] = a[count - 1];
                right++;
                count++;
            }

        }

        if (left == length - 1) {
            a[count++] = arr1[left];
            while (right < length - 1) {
                a[count++] = arr2[right++];
            }
            a[count++] = arr2[right++];
        } else {
            a[count++] = arr2[right];
            while (left < length - 1) {
                a[count++] = arr1[left++];
            }
            a[count++] = arr1[left++];
        }

        return a[index];
    }

    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here
        int length = arr.length;
        LinkedList<Integer> linkedList = new LinkedList<>();
        int i = 0, maxCommonSize = 0;
        while (i < length) {
            if (linkedList.contains(arr[i])) {
                while (linkedList.peekFirst() != arr[i]) {
                    linkedList.removeFirst();
                }
                linkedList.removeFirst();
            }
            linkedList.add(arr[i]);
            i++;
            maxCommonSize = Math.max(maxCommonSize, linkedList.size());
        }
        return maxCommonSize;

    }

    public int maxLength2(int[] arr) {
        int[] lastPos = new int[100005];
        int len = arr.length;
        int start = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int now = arr[i];
            start = Math.max(start, lastPos[now]);
            res = Math.max(res, i - start + 1);
            lastPos[now] = i + 1;
        }

        return res;
    }



}
