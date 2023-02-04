package com.example.leetcode;

import com.example.leetcode.common.ListNode;

public class LeetCode_L83_RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2)));
        ListNode listNode1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))));
        System.out.println(deleteDuplicates(listNode));
        System.out.println(deleteDuplicates(listNode1));
        System.out.println(deleteDuplicates(listNode2));
    }

    //1->2->2  => 1->2
    //1->1->2  => 1->2
    //1ms, 43.4MB
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;

        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;

            }
        }
        return head;
    }

    // 1->2->2->3 => 1->2->3
    //0ms,43.4MB 快慢指针
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(-1);
        ListNode cur = head;
        while (cur.next != null && (cur.val == cur.next.val)) {
            cur = cur.next;
        }
        res.next = cur;
        ListNode slow = cur;
        ListNode fast = cur.next;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next.val = fast.val;
                fast = fast.next;
                slow = slow.next;
            } else {
                fast = fast.next;
            }
        }
        slow.next = null;
        return res.next;
    }
}
