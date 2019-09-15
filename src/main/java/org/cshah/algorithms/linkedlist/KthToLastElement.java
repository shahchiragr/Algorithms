package org.cshah.algorithms.linkedlist;

/**
 * Created by chirag on 10/12/16.
 */
public class KthToLastElement {

    static int count = 0;
    public static ListNode getkthToLast(ListNode node, int k) {
        if (node == null)
            return  null;

        ListNode node1=  getkthToLast(node.next, k);
         count++;

        if (count == k)
            return node;


        return  node1;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        n.next.next.next.next.next = new ListNode(6);
        n.next.next.next.next.next.next = new ListNode(7);
        n.next.next.next.next.next.next.next = new ListNode(8);
        n.next.next.next.next.next.next.next.next = new ListNode(9);

        int k = 3;
        System.out.println(k + "th to last element is " + KthToLastElement.getkthToLast(n, k).val);

    }
}
