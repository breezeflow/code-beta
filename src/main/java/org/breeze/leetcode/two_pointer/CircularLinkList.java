package org.breeze.leetcode.two_pointer;

import org.breeze.leetcode.ListNode;

import java.util.HashSet;

/**
 * 重点：双指针思路 + 临界情况的分析
 */
public class CircularLinkList {

    public boolean hasCycle(ListNode head) {
        // 临界情况：链表为空、只有一个节点
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && slow != null) {
            // 慢指针走一步
            slow = slow.next;
            // 快指针走两步
            fast = fast.next.next;
            // 如果快指针走完了，为空，说明没有环，有环一定不会结束
            if (fast == null) {
                return false;
            }
            // 有环一定不会结束，且一定会相遇
            if (fast == slow) {
                return true;
            }

        }
        return false;
    }

    // 思路：标记法
    public boolean hasCycle2(ListNode head) {
        // 遍历，访问过的就存到 set 中
        HashSet<ListNode> browsed = new HashSet<>();
        while (head != null) {
            // 如果已经访问过了，则说明存在环
            if (!browsed.add(head)) {
                return true;
            }
            head = head.next;
        }
        // 存在环一定不会结束，结束了，就说明没有环
        return false;
    }

    // 返回链表开始入环的第一个节点
    public ListNode detectCycle(ListNode head) {
        // 遍历，访问过的就存到 set 中
        HashSet<ListNode> browsed = new HashSet<>();
        while (head != null) {
            // 如果已经访问过了，则说明存在环，当前就是第一个节点
            if (!browsed.add(head)) {
                return head;
            }
            head = head.next;
        }
        // 存在环一定不会结束，结束了，就说明没有环
        return null;
    }

}
