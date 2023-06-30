package org.breeze.base.DataStructure.LinkedList;

/**
 * 单链表 常用操作
 * 1. 单链表的反转
 * 2. 链表中环的检测
 * 3. 合并有序链表
 * 4. 查询链表中间值
 * 5. 删除链表的倒数第n个节点
 */

public class ListUtils {

    /**
     * 两个有序链表的合并
     *
     * @param l1
     * @param l2
     * @return
     */
//    public static Node mergeOrderList(Node l1, Node l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        Node p = l1;
//        Node q = l2;
//        Node head;
//        //寻找新链表的第一个节点
//        if (p.data < q.data) {
//            head = p;
//            p = p.next;
//        } else {
//            head = q;
//            q = q.next;
//        }
//        Node r = head;
//        while (p != null & q != null) {
//            if (p.data < q.data) {
//                r.next = p;
//                p = p.next;
//            } else {
//                r.next = q;
//                q = q.next;
//            }
//            r = r.next;
//        }
//        if (p != null) {
//            r.next = p;
//        }
//        if (q != null) {
//            r.next = q;
//        }
//        return head;
//    }
//
//    /**
//     * 查询链表的中间节点：快慢指针，慢指针走一步，快指针走两步，快指针走完，慢指针到达中点。
//     *
//     * @param head
//     * @return
//     */
//    public static Node findListMiddata(Node head) {
//        if (head == null) return null;
//        Node slow = head;
//        Node fast = head;
//        while (fast != null && fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//
//    /**
//     * 删除链表倒数第n个节点
//     *
//     * @return
//     */
//    public static Node deleteLastKthNode(Node list, int n) {
//        Node fast = list;
//        int i = 1;
//        while (fast != null && i < n) {
//            fast = fast.next;
//            ++i;
//        }
//
//        if (fast == null) return list;
//
//        Node slow = list;
//        Node prev = null;
//        while (fast.next != null) {
//            fast = fast.next;
//            prev = slow;
//            slow = slow.next;
//        }
//
//        if (prev == null) {
//            list = list.next;
//        } else {
//            prev.next = prev.next.next;
//        }
//        return list;
//    }
//
//    /**
//     * 删除链表中重复的元素
//     *
//     * @param head
//     * @return
//     */
//    public static Node deleteSameNode(Node head) {
//        if (head == null || head.next == null) return head;
//        Node p = head, q = p.next;
//        while (q != null && p.next != null) {
//            if (p.data != q.data) {
//                q = q.next;
//                p = p.next;
//            } else {
//                p.next = q.next;
//                q = q.next;
//            }
//        }
//        return head;
//    }


}