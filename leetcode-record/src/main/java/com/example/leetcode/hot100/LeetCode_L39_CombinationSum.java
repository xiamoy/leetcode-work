package com.example.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_L39_CombinationSum {

    public static void main(String[] args) {
        LeetCode_L39_CombinationSum code = new LeetCode_L39_CombinationSum();
        int[] c = {2, 3, 6, 7};
        int target = 7;
        System.out.println(code.combinationSum(c, target));

    }


    //5ms,44.5MB
    // https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates.length == 1 && candidates[0] > target) {
            return list;
        }

        List<Integer> temp = new ArrayList<>();
        backtrack(0, temp, list, candidates, target);

        return list;
    }

    public void backtrack(int begin, List<Integer> temp, List<List<Integer>> list, int[] candidates, int target) {
        if (begin >= candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(i, temp, list, candidates, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }

    public int sum(List<Integer> temp, int[] candidates) {
        int res = 0;
        for (int x : temp) {
            res += candidates[x];
        }
        return res;
    }
}
