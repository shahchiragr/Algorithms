package org.cshah.algorithms.linkedlist;

/**
 * Created by chirag on 11/25/14.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this(val,null);
    }
    public ListNode(int val, ListNode n) {
        this.val = val;
        this.next = n;
    }


}
