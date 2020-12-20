package com.example.nowcoder;

import java.util.LinkedList;

/**
 * 找到字符串的最长无重复字符子串
 * @link https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=188&&tqId=36856&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class NowCoder_NC41 {
    public static void main(String[] args) {
//        int[] arr = new int[]{2, 2, 3, 4, 3};//3
//        int[] arr = new int[]{2, 3, 4,5};//4
        int[] arr = new int[]{2, 3, 4,3};//3
        Solution_NC41 solution_nc41=new Solution_NC41();
        int maxLength = solution_nc41.maxLength(arr);
        System.out.println(maxLength);
    }
}

class Solution_NC41{


    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        //TODO time exceeded

        int length=arr.length;
        LinkedList<Integer> linkedList=new LinkedList<>();
        int i=0,maxCommonSize=0;
        while (i<length){
            if (linkedList.contains(arr[i])){
                int index = linkedList.indexOf(arr[i]);
                if (index>=0){
                    linkedList.removeFirst();
                }
            }
            linkedList.add(arr[i]);
            i++;
            maxCommonSize=Math.max(maxCommonSize,linkedList.size());
        }
        return maxCommonSize;
    }

    // by others commit
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