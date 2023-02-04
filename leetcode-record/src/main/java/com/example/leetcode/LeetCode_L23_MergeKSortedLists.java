package com.example.leetcode;


import com.example.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode_L23_MergeKSortedLists {

    public static void case1() {
        ListNode headA = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode headB = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode headC = new ListNode(3, new ListNode(4));
        ListNode[] arr = new ListNode[]{headA, headB, headC};


        System.out.println(mergeKLists(arr));// 1->1->3->3->4->4->4->5
    }

    public static void main(String[] args) {
        ListNode headA = null;
        ListNode headB = new ListNode(-1, new ListNode(5, new ListNode(11)));
        ListNode headC = null;
        ListNode headD = new ListNode(6, new ListNode(10));
        ListNode[] arr = new ListNode[]{headA, headB, headC, headD};


        System.out.println(mergeKLists(arr));// -1->5->6->10->11
    }


    // 11ms, 48.6M
    public static ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (l1, l2) -> l1.val - l2.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (!queue.isEmpty()) {
            ListNode top = queue.poll();
            cur.next = new ListNode(top.val);
            if (top.next != null) {
                queue.add(top.next);
            }

            cur = cur.next;
        }
        return head.next;
    }

    // 10ms ,51.2M
    public static ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoList(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        ListNode leftSortedNode = mergeKLists(Arrays.copyOfRange(lists, 0, mid + 1));
        ListNode rightSortedNode = mergeKLists(Arrays.copyOfRange(lists, mid + 1, lists.length));
        return mergeTwoList(leftSortedNode, rightSortedNode);
    }


    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1 == l2) {
            return l1;
        }

        ListNode head = new ListNode(-1), cur = head;
        ListNode c1 = l1, c2 = l2;
        while (c1 != null && c2 != null) {
            int val = c1.val;
            if (c1.val <= c2.val) {
                c1 = c1.next;
            } else {
                val = c2.val;
                c2 = c2.next;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        cur.next = c1 != null ? c1 : c2;
        return head.next;
    }

    //6ms, 51.6M
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public static ListNode mergeKLists(ListNode[] lists, int begin, int end) {

        if (begin == end) {
            return lists[begin];
        }
        int mid = begin + (end - begin) / 2;

        ListNode leftNode = mergeKLists(lists, begin, mid);
        ListNode rightNode = mergeKLists(lists, mid + 1, end);
        return mergeTwoList(leftNode, rightNode);

    }

}
