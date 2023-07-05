package org.breeze.DataStructure.LinkedList;


import org.breeze.DataStructure.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 *
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 */
public class ReverseList2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ReverseList2 demo = new ReverseList2();
        ListNode head = demo.reverseBetween(l1, 2, 4);
        head.display();
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode pre= new ListNode(),p =null,q = head;
        pre.next = head;
        while (count<=right){
            if(count<=left){
                if(count == left-1){
                    pre = q;
                }
                if(count == left){
                    p = q;
                }
                q = q.next;
            }else{
                ListNode temp = q.next;
                p.next= temp;
                q.next = pre.next;
                pre.next = q;
                q = temp;
            }
            count ++;
        }
        if(left == 1) return pre.next;
        else return head;
    }



}
