package com.example.leetcode.hot100;

import com.example.leetcode.common.ListNode;

public class LeetCode_L328_OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = oddEvenList(node);
        System.out.println(listNode);

    }

//    public ListNode oddEvenList(ListNode head) {
//        if(head==null||head.next==null||head.next.next==null){
//            return head;
//        }
//        ListNode oddNode = head, evenNode=head.next;
//        while(oddNode!=null && evenNode.next!=null){
//            ListNode nextOdd = evenNode.next;
//            oddNode.next = oddNode.next.next;
//            ListNode nextEven = evenNode.next.next;
//            nextOdd.next = evenNode;
//            evenNode.next = nextEven;
//
//            oddNode = nextOdd;
//            evenNode = nextEven;
//        }
//    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenBegin = even;
        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenBegin;

        return head;

    }
}
