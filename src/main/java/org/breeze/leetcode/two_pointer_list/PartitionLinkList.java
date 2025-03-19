package org.breeze.leetcode.two_pointer_list;

import org.breeze.leetcode.ListNode;

public class PartitionLinkList {

    public ListNode partition(ListNode head, int x) {
        // [1,4,3,2,5,2]    3
        // [1,2,2,4,3,5]
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                // p2(l2) 记录大于等于 目标值的节点，不考虑这些值之间的大小
                p2.next = p;
                p2 = p2.next;
            } else {
                // p1(l1) 记录小于 目标值的节点，不考虑这些值之间的大小
                p1.next = p;
                p1 = p1.next;
            }
            // 去掉原始链表中节点的链条
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = l2.next;
        return l1.next;
    }

}
