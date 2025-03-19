package org.breeze.leetcode.two_pointer;

import org.breeze.leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;


public class LinkListMiddleNode {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        // 记录访问过的节点
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode p = head;
        // 记录链表的总长度
        int i = 0;
        while (p != null) {
            i++;
            // 按照索引顺序存储节点
            map.put(i, p);
            p = p.next;
        }
        // 找到中间节点
        int mid = i / 2 + 1;
        return map.get(mid);
    }

}
