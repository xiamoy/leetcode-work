package com.example.leetcode.day03;

import java.util.*;

public class Main03 {

    public static void main(String[] args) {

//        testMergeListDemo();

        String roman = new Solution().intToRomanByOthers(2000);
        System.out.println(roman);


    }


    public static void testMergeListDemo() {
        ListNode list1 = creatListNode(new int[]{1, 2});
        ListNode list2 = creatListNode(new int[]{3});

        ListNode mergeTwoLists = new Solution().mergeTwoLists(list1, list2);
        pringListNode(mergeTwoLists);

    }

    public static ListNode creatListNode(int... values) {
        ListNode listNode = new ListNode(0);
        ListNode index = listNode;
        for (int x : values) {
            ListNode temp = index;

            temp.next = new ListNode(x);
            index = temp.next;

        }
        return listNode.next;
    }

    public static void pringListNode(ListNode listNode) {
        ListNode point = listNode;
        List<Integer> list = new ArrayList<>();
        while (point != null) {
            list.add(point.val);
            point = point.next;
        }
        System.out.println(list);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    //custom implement
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode mergedList = l1, list2 = l2;

        if (l1.val > l2.val) {
            mergedList = l2;
            list2 = l1;
        }

        ListNode l1Index = mergedList, l2Index = list2;
        while (l1Index != null && l2Index != null) {
            int leftIndexVal = l1Index.val;
            int rightIndexVal = l2Index.val;

            if (leftIndexVal <= rightIndexVal) {

                if (l1Index.next != null) {
                    if (l1Index.next.val < rightIndexVal) {
                        l1Index = l1Index.next;

                    } else {
                        ListNode originalNext = l1Index.next;
                        ListNode addNode = new ListNode(rightIndexVal);
                        l1Index.next = addNode;
                        addNode.next = originalNext;
                        l2Index = l2Index.next;
                    }
                } else {
                    l1Index.next = l2Index;
                    break;
                }

            } else {
                l2Index = l2Index.next;
            }
        }

        return mergedList;
    }


    //most voted
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {


        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000


    private Map<Integer, String> romanMap = new HashMap<Integer, String>() {{
        put(0, "");
        put(1, "I");
        put(2, "II");
        put(3, "III");
        put(4, "IV");
        put(5, "V");
        put(6, "VI");
        put(7, "VII");
        put(8, "VIII");
        put(9, "IX");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000, "M");
    }};

    private Map<Integer, String> romanMap2 = new HashMap<Integer, String>() {{
        put(1000, "C,M");
        put(500, "C,D");
        put(100, "X,C");
        put(50, "X,L");
        put(10, "I,X");
    }};


    //custom implement
    public String intToRoman(int num) {

        if (romanMap.containsKey(num)) {
            return romanMap.get(num);
        }

        if (num < 100) {
            return rangeRoman(num, 100);
        }

        if (num < 1000) {
            return rangeRoman(num, 1000);
        }

        int divider = 10;
        int highDigit = num / divider;
        int mod = num - highDigit * divider;

        while (mod == 0 && highDigit != 0) {
            divider *= 10;
            highDigit = num / divider;
            mod = num - highDigit * divider;
        }

        if (highDigit == 0) {
            int digit = num / 1000;
            String result = "";
            while (digit != 0) {
                result += "M";
                digit--;
            }
            return result;
        }


        return intToRoman(highDigit * divider) + intToRoman(mod);

    }

    public String rangeRoman(int num, int range) {

        int divider = range / 10;
        int midRange = range / 2;
        String[] midRangeRomans = romanMap2.get(midRange).split(",");
        String midRangeRoman = midRangeRomans[1];

        int div = num / divider;
        int mod = num - div * divider;

        String modRoman = mod>10?intToRoman(mod):romanMap.get(mod);

        if (Math.abs(div * divider - midRange) == divider) {
            return num < midRange ? midRangeRomans[0] + midRangeRoman + modRoman : midRangeRoman + midRangeRomans[0] + modRoman;
        }

        if (Math.abs(div * divider - range) == divider) {
            String[] s = romanMap2.get(range).split(",");
            return num < range ? s[0] + s[1] + modRoman : s[1] + s[0] +modRoman;
        }
        if (div == 5) {
            return midRangeRoman + modRoman;
        }

        String result = "";
        if (div < 4) {
            while (div != 0) {
                result += midRangeRomans[0];
                div--;
            }
        }

        if (div > 6) {
            result = midRangeRoman;
            while (div > 5) {
                result += midRangeRomans[0];
                div--;
            }

        }
        return result + modRoman;
    }


    public String intToRomanByOthers(int n) {
        String o[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String t[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String c[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String m[]={"","M","MM","MMM"};
        return m[n/1000]+c[(n%1000)/100]+t[(n%100)/10]+o[n%10];
    }


}
