package com.example.leetcode;

import com.example.leetcode.common.ListNode;

public class LeetCode_L206_ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverseList(listNode));

    }

    //     1->2->3->4->5 To 5->4->3->2->1
    //prev cur
    //1ms, 43.3MB
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

    }

    //0ms, 42.5MB
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverseList(head, null);

    }

    public static ListNode reverseList(ListNode cur, ListNode prev) {
        if (cur == null) {
            return prev;
        }
        ListNode next = cur.next;
        cur.next = prev;
        return reverseList(next, cur);

    }


}
