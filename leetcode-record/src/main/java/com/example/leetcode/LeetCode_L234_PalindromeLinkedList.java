package com.example.leetcode;

import com.example.leetcode.common.ListNode;

public class LeetCode_L234_PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,
                new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(l1));

    }

    // 4ms, 58.6MB
    // 1 2 2 1 => fast==null
    // 1 2 1 =>
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right;
        if (fast == null) {//even node
            right = slow;
            pre.next = null;
        } else { // odd
            right = slow;
            slow.next = null;
        }
        ListNode l1 = head;
        ListNode l2 = reverse(right);
        while (l1 != null && l2 != null && l1.val == l2.val) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    public static ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode pre = null, cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
