package com.example.leetcode.day02;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
//        List<List<Integer>> permute = new Solution().permute(arr);
//        System.out.println(permute.size());

//        List<List<Integer>> subsets = new SolutionOthers().subsets(arr);
//        System.out.println(subsets.size());

        List<List<Integer>> permutes = new SolutionOthers().permute(arr);
        System.out.println(permutes.size());
    }
}

class Solution {

    /**
     * Runtime: 19 ms,faster than 5.10%
     * Memory Usage: 38.7 MB, less than 30.50%
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Set<List<Integer>> sets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            ArrayList<Integer> integers = new ArrayList<>(list);
            integers.remove(i);
            sets.addAll(sort(target, integers));
        }
        return new ArrayList<>(sets);
    }

    public Set<List<Integer>> sort(int num, List<Integer> arr) {
        Set<List<Integer>> result = new HashSet<>();
        if (arr.size() == 0) {
            result.add(Arrays.asList(num));
            return result;
        }

        int leftJoinTarget = num;

        Set<List<Integer>> rightJoinList = new HashSet<>();

        for (int index = 0; index < arr.size(); index++) {
            List<Integer> res = new ArrayList<>(arr);
            res.remove(index);
            rightJoinList.addAll(sort(arr.get(index), res));
        }

        for (List<Integer> item : rightJoinList) {
            result.addAll(joinList(leftJoinTarget, item));
        }
        return result;
    }

    public Set<List<Integer>> joinList(int num, List<Integer> arr) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < arr.size(); i++) {
            List<Integer> tmp = new ArrayList<>(arr);
            tmp.add(i, num);
            result.add(tmp);
        }

        return result;
    }

}

class SolutionOthers{

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
