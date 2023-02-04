package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_L136_SingleNumber {
    public static void main(String[] args) {

    }

    //30ms, 54.1MB
    public static int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i) && map.get(i) == 1) {
                map.remove(i);
            } else {
                map.put(i, 1);
            }
        }
        return map.keySet().iterator().next();
    }

    //1ms, 42.1MB
    //交换律：a ^ b ^ c <=> a ^ c ^ b
    //
    //任何数与0异或为任何数 0 ^ n => n
    //
    //相同的数异或为0: n ^ n => 0
    //
    //var a = [2,3,2,4,4]
    //
    //2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
    public static int singleNumber(int[] nums) {
        //异或运算
        int result = 0;
        for (int x : nums) {
            result ^= x;
        }
        return result;

    }
}
