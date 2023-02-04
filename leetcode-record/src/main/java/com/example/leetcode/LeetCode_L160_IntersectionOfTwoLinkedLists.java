package com.example.leetcode;


import com.example.leetcode.common.ListNode;

public class LeetCode_L160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode commonNode = new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5))));
        ListNode headA = new ListNode(4, commonNode);
        ListNode headB = new ListNode(5, new ListNode(6, commonNode));

        System.out.println(getIntersectionNode(headA, headB));
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode aCur = headA, bCur = headB;
        if (aCur == null || bCur == null) {
            return null;
        }

        while (aCur != bCur) {
            aCur = aCur == null ? headB : aCur.next;
            bCur = bCur == null ? headA : bCur.next;
        }

        return aCur;
    }

    public static int len(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aCur = headA, bCur = headB;
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = len(headA);
        int lenB = len(headB);

        while (lenA > lenB) {
            aCur = aCur.next;
            lenA--;
        }
        while (lenB > lenA) {
            bCur = bCur.next;
            lenB--;
        }

        while (aCur != bCur) {
            aCur = aCur.next;
            bCur = bCur.next;
        }

        return aCur;

    }

}
