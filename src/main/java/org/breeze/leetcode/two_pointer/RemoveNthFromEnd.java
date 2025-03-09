package org.breeze.leetcode.two_pointer;

import org.breeze.leetcode.ListNode;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 建立虚拟头节点 指向 head
        ListNode pre = new ListNode(0,head);
        ListNode p = pre;
        ListNode q = head;
        // 从 head 开始找 第 n 个节点
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        // 从 p(虚拟头节点) 节点开始滑动，直到 q 到达链表的尾部
        while (q!=null){
            p = p.next;
            q = q.next;
        }
        // 删除 p 下一个节点
        p.next = p.next.next;
        // 如果删除的是head节点，即 p = pre ，则 pre.next = null
        // 如果删除的是非head节点，则返回head节点
        return pre.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 0) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        int i = 1;
        // 双指针间隔 N + 1个节点，寻找倒出第 N 个节点，即 P 指针对应的节点的下一个节点
        while (q != null) {
            if (i <= n) {
                i++;
            } else {
                p = p.next;
            }
            q = q.next;
        }
        // 删除 p 指针对应的节点的下一个节点
        if (p.next == null) {
            return null;
        }
        if (i == n) {
            return head.next;
        }
        p.next = p.next.next;
        return head;
    }
}
