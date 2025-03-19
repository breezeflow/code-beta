package org.breeze.leetcode.two_pointer_list;

import org.breeze.leetcode.ListNode;

public class FindNthNodeFromEnd {

    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode p = head;
        ListNode q = head;
        // 找到距离head 第 cnt 个节点
        for (int i = 0; i < cnt; i++) {
            q = q.next;
        }
        // 此时 p q 相隔 cnt，p随q移动到链表结尾，p就是倒数第cnt个
        while (q != null) {
            q = q.next;
            p = p.next;
        }
        return p;
    }

}
