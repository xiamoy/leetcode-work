package com.example.leetcode;


import com.example.leetcode.common.ListNode;

/**
 * Add two numbers
 *
 * @link https://leetcode.com/problems/add-two-numbers/
 */
public class LeetCode_L2_AddTwoNumbers {

    public static void main(String[] args) {
//        ListNode list1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode list2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        "".charAt(1);
        ListNode list1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode list2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.println(addTwoNumbers(list1, list2));
    }

    //4ms, 47.8M
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode index1 = l1, index2 = l2;
        ListNode result = new ListNode(1);
        ListNode cur = result;
        int append = 0;
        while (index1 != null && index2 != null) {
            int value = index1.val + index2.val + append;
            append = value / 10;
            cur.next = new ListNode(value % 10);
            index1 = index1.next;
            index2 = index2.next;
            cur = cur.next;
        }

        while (index1 != null) {
            int value = index1.val + append;
            append = value / 10;
            cur.next = new ListNode(value % 10);
            index1 = index1.next;
            cur = cur.next;
        }

        while (index2 != null) {
            int value = index2.val + append;
            append = value / 10;
            cur.next = new ListNode(value % 10);
            index2 = index2.next;
            cur = cur.next;
        }
        if (append > 0) {
            cur.next = new ListNode(append);
        }

        return result.next;
    }

    //4ms,46.5Mb
    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        int append = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                append += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                append += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(append % 10);
            cur = cur.next;
            append /= 10;
        }
        if (append > 0) {
            cur.next = new ListNode(append);
        }
        return head.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, other = null;
        if (l1 != null) {
            head = l1;
            other = l2;
        } else {
            head = l2;
            other = l1;
        }
        ListNode cur = head, prev = cur;
        int append = 0;
        while (cur != null) {
            int sum = cur.val + append;
            if (other != null) {
                sum += other.val;
                other = other.next;
            }
            cur.val = sum % 10;
            append /= 10;
            prev = cur;
            cur = cur.next;
        }
        while (other != null) {
            int sum = other.val + append;
            prev.next = new ListNode(sum % 10);
            append /= 10;
            prev = prev.next;
            other = other.next;
        }

        if (append > 0) {
            prev.next = new ListNode(append);
        }
        return head;
    }
}

