package com.example.leetcode;

import com.example.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/discuss/11030/My-accepted-java-code.-used-recursion.
 */
public class LeetCode_L24_SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(swapPairs(listNode));
    }

    // -1  1->2->3->4 => 2->1->4->3
    // cur n1 n2
    //0ms,41.9MB
    public static ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode next1 = cur.next;
            ListNode next3 = cur.next.next.next;


            cur.next = cur.next.next;
            cur.next.next = next1;
            next1.next = next3;
            cur = cur.next.next;
        }
        return dummy.next;

    }

    // -1  1->2->3->4 => 2->1->4->3
    // cur n1 n2
    public static ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode next1 = cur.next;
            ListNode next2 = cur.next.next;
            ListNode next3 = cur.next.next.next;

            cur.next.next = next3; //n1的next指向3 1->2 变成 1->3
            cur.next = next2;// cur的next指向2， -1-》1 变成-1->2
            cur.next.next = next1;// n2的next指向1, 2->3 变成2->1
            cur = cur.next.next;
        }
        return dummy.next;

    }

    //递归 TODO
    //  1->2->3->4 => 2->1->4->3
    public static ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
