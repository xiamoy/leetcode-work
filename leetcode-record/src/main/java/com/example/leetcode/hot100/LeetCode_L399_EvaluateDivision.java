package com.example.leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode_L399_EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] val = {2.0, 3.0};

        List<List<String>> query = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"),
                Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        double[] doubles = calcEquation(list, val, query);
        System.out.println(doubles);
    }

    //TODO today
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> map = new HashMap<>(equations.size());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> curPair = equations.get(i);
            map.put(curPair.get(0), String.valueOf(values[i]) + "#" + curPair.get(1));
            set.add(curPair.get(0));
            set.add(curPair.get(1));
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> curQuery = queries.get(i);
            String first = curQuery.get(0);
            String second = curQuery.get(1);
            if (set.contains(first) && first.equals(second)) {
                res[i] = 1.0;
                continue;
            }

            if (map.containsKey(first)) {
                String tmpFirst = first;
                double val = 1.0;
                while (map.containsKey(tmpFirst)) {
                    String s = map.get(tmpFirst);
                    String[] split = s.split("#");
                    val *= Double.parseDouble(split[0]);
                    if (s.endsWith("#" + second)) {
                        res[i] = val;
                        break;
                    }
                    tmpFirst = split[1];
                }

            }

            if (map.containsKey(second)) {

                double val = 1.0;
                while (map.containsKey(second)) {
                    String value = map.get(second);
                    String[] split = value.split("#");
                    val *= Double.parseDouble(split[0]);
                    if (split[1].equals(first)) {
                        res[i] = 1 / val;
                        break;
                    }
                    second = split[1];
                }

            }
            res[i] = -1.0;
        }
        return res;
    }

}
