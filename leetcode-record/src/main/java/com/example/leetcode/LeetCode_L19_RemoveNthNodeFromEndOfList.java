package com.example.leetcode;

import com.example.leetcode.common.ListNode;

public class LeetCode_L19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head2 = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd(head, 2)); // 1 2 3 5
        System.out.println(removeNthFromEnd(head2, 2));// 2

    }

    //1ms, 42.4MB
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1, head);

        ListNode fast = dummyHead, slow = dummyHead;
        while (n-- >= 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        ListNode prev = slow;
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return dummyHead.next;

    }

    //0ms, 40.7MB
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1, head);

        ListNode fast = dummyHead, slow = dummyHead;
        while (n-- >= 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;

    }

    //1ms, 42.1MB
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1, head);

        ListNode fast = dummyHead, slow = dummyHead;
        while (n-- > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;

    }
}
