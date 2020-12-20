package com.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
//        List<List<Integer>> list = new ArrayList<>();
//        list.add(Arrays.asList(1, 2, 3));
//        list.add(Arrays.asList(4, 5, 6));
//        System.out.println(findMatrix(list));

        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)]"));

//        String test = "as[]sj";
//        test = test.replaceAll("\\[\\]", "");
//        System.out.println(test);
    }

    //Element 	Equation 		Values		b(x, y)
    //-------		-----------------------	-------------	------
    //b(0,0)		a(0,0)			1		1
    //b(0,1)		a(0,0)+a(0,1)		1+2		3
    //b(0,2)		a(0,0)+a(0,1)+a(0,2) 	1+2+3		6
    //b(1,0)		a(0,0)+a(1,0)		1+4		5
    //b(1,1)		a(0,0)+a(0,1)		1+2+4+5		12
    //		+a(1,0)+a(1,1)
    //b(1,2)		a(0,0)+a(0,1)+a(0,2)	1+2+3+4+5+6	21
    //		+a(1,0)+a(1,1)+a(1,2)

    public static List<List<Integer>> findMatrix(List<List<Integer>> a) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();

        int num = 0;
        for (int i = 0; i < a.size(); i++) {
            result.add(new ArrayList<>());
            List<Integer> integers = a.get(i);
            for (int j = 0; j < integers.size(); j++) {
//                int num = getRowCount(a, i, j);
//                num += a.get(i).get(j);
                int newVal = getCurrentVal(a, i, j) + a.get(i).get(j);
                result.get(i).add(j, newVal);
//                num = 0;
            }

        }
        return result;
    }

    static int getCurrentVal(List<List<Integer>> a, int i, int j) {
        try {
            return a.get(i).get(j).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static int getRowCount(List<List<Integer>> a, int row, int col) {
        int num = 0;
        for (int i = 0; i <= row; i++) {
//           num= a.stream().mapToInt(x->x.stream().reduce(col, new BinaryOperator<Integer>() {
//                @Override
//                public Integer apply(Integer integer, Integer integer2) {
//                    return integer+integer2;
//                }
//            })).sum();

            for (int j = 0; j <= col; j++) {
                num += a.get(i).get(j);
            }
        }
        return num;
    }

    static String find(List<Integer> list, Integer k) {
        Optional<Integer> optionalInteger = list.stream()./*sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).*/filter(item -> item.equals(k)).findAny();

        return list.stream().filter(item -> item.equals(k)).findAny().isPresent() ? "YES" : "NO";
    }

    static List<Integer> oddNumbers(int l, int r) {
        return IntStream.rangeClosed(l, r).filter(value -> value % 2 != 0).sorted().boxed().collect(Collectors.toList());

    }

    public static final String left_bracket_1 = "[";
    public static final String left_bracket_2 = "(";
    public static final String left_bracket_3 = "{";
    public static final String right_bracket_1 = "]";
    public static final String right_bracket_2 = ")";
    public static final String right_bracket_3 = "}";

    static String[] brances(String[] values) {


        List<String> result = new LinkedList<>();

        for (String val : values) {

            char[] chars = val.toCharArray();
            Stack<String> stack = new Stack<>();
            for (char item : chars) {
                if (stack.isEmpty()) {
                    stack.push(val + "");
                    continue;
                }

                if (match(stack.peek(), String.valueOf(item))) {
                    stack.pop();
                } else {
                    stack.push(String.valueOf(item));
                }
            }
            result.add(stack.isEmpty() ? "YES" : "NO");
        }
        return result.toArray(new String[]{});
    }

    public static boolean isValid(String s) {
        String temp = s;
        if (s.isEmpty() ){
            return true;
        }

        if (!temp.contains("{}") && !temp.contains("()") && !temp.contains("[]")){
            return false;
        }

//        if (temp.contains("()")) {
            temp = temp.replaceAll("\\(\\)", "");
//        }
//        if (s.contains("[]")) {
            temp = temp.replaceAll("\\[\\]", "");
//        }
//        if (temp.contains("{}")) {
            temp = temp.replaceAll("\\{\\}", "");
//        }


        return isValid(temp);
    }


    static boolean match(String key, String val) {
        if (left_bracket_1.equals(key)) {
            return right_bracket_1.equals(val);
        }
        if (left_bracket_2.equals(key)) {
            return right_bracket_2.equals(val);
        }
        if (left_bracket_3.equals(key)) {
            return right_bracket_3.equals(val);
        }
        return false;
    }


}
