package org.breeze.leetcode.two_pointer;

import org.breeze.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class CrossLinkList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        Set<ListNode> seen = new HashSet<>();
        while (p != null || q != null) {
            if (p != null) {
                if (seen.add(p)) {
                    p = p.next;
                } else {
                    return p;
                }
            }
            if (q != null) {
                if (seen.add(q)) {
                    q = q.next;
                } else {
                    return q;
                }
            }
        }
        return null;
    }

}
