package com.example.nowcoder;

/**
 * 	数组中未出现的最小正整数
 * @link https://www.nowcoder.com/practice/8cc4f31432724b1f88201f7b721aa391?tpId=188&&tqId=36873&rp=1&ru=/ta/job-code-high-week&qru=/ta/job-code-high-week/question-ranking
 */
public class NowCoder_NC30 {
    public static void main(String[] args) {
        Solution_NC30 solution_nc30=new Solution_NC30();
        int[] arr1 = new int[]{-1, 2, 3, 4};
        System.out.println(solution_nc30.minNumberdisappered(arr1));
    }
}

class Solution_NC30{

    /**
     * return the min number
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int minNumberdisappered (int[] arr) {
        // write code here
        int res=1;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<1){
                break;
            }
            res=Math.max(arr[i]+1,res);
        }

        return res;
    }
}
