package org.breeze.leetcode.two_pointer;

import org.breeze.leetcode.ListNode;

import java.util.PriorityQueue;


public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode pre = new ListNode(0, null);
        ListNode r = pre;
        // 初始化一个 默认升序的 优先队列，底层是一个小根堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (r1, r2) -> (r1.val - r2.val));
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        while (!pq.isEmpty()) {
            // 取出小根堆中最小的一个节点，并从队列中删除该节点
            ListNode minHead = pq.poll();
            r.next = minHead;
            // 将该链表的下一个节点放入队列中
            if (minHead.next != null) {
                pq.offer(minHead.next);
            }
            // 新链表往下移动
            r = r.next;
        }
        return pre.next;
    }

}
