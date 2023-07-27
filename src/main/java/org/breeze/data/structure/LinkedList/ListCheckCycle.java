package org.breeze.data.structure.LinkedList;



import org.breeze.data.structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表检测环
 */
public class ListCheckCycle {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        ListNode l5 = new ListNode(5);

        ListCheckCycle demo = new ListCheckCycle();
//        System.out.println(demo.checkCircle(l5));
        System.out.println(demo.checkCircle2(l5));

        demo = null;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public Boolean checkCircle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null) {
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * hash表的方法检测环，缺点  需要使用额外的空间，遍历的个数可能要比快慢指针多
     *
     * @param head
     * @return
     */
    public Boolean checkCircle2(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


}
