package org.breeze.base.DataStructure.LinkedList;


import org.breeze.base.DataStructure.ListNode;

/**
 * 单链表的反转
 */
public class ReverseSingleList {

    /**
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        if(head == null) return head;
        ListNode newHead = head;
        ListNode p = head.next;
        newHead.next = null;
        while (p!=null){
            ListNode temp = p.next;
            p.next = newHead;
            newHead = p;
            p =temp;
        }
        return newHead;
    }



}
