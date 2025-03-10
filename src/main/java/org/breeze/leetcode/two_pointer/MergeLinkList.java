package org.breeze.leetcode.two_pointer;

import org.breeze.leetcode.ListNode;

public class MergeLinkList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(0, null);
        ListNode r = pre;
        ListNode p = list1;
        ListNode q = list2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        while (p != null) {
            r.next = p;
            p = p.next;
            r = r.next;
        }
        while (q != null) {
            r.next = q;
            q = q.next;
            r = r.next;
        }
        return pre.next;
    }

}
