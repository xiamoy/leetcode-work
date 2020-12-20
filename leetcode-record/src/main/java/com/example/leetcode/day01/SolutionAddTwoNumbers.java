package com.example.leetcode.day01;


public class SolutionAddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentLeft = l1, currentRight = l2;
        ListNode result = new ListNode(0);
        ListNode resultTemp = result;
        int updigit = 0;
        while (currentLeft != null || currentRight != null || updigit != 0) {
            int total = updigit;
            if (currentLeft != null) {
                total += currentLeft.val;
                currentLeft = currentLeft.next;
            }
            if (currentRight != null) {
                total += currentRight.val;
                currentRight = currentRight.next;
            }
            updigit = total / 10;

            ListNode temp = new ListNode(total % 10);
            resultTemp.next = temp;
            resultTemp = resultTemp.next;

        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1);
        ListNode dum = l2;
        for (int i = 0; i < 9; i++) {
            ListNode tmp = new ListNode(9);
            dum.next = tmp;
            dum = dum.next;
        }


        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}