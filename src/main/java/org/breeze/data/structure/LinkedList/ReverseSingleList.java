package org.breeze.data.structure.LinkedList;


import org.breeze.data.structure.ListNode;

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
