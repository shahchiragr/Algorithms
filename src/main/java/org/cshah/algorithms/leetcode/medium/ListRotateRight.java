package org.cshah.algorithms.leetcode.medium;

import org.cshah.algorithms.linkedlist.ListNode;

public class ListRotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        int totalNodes = getTotalNodes(head);

        if (k == totalNodes || totalNodes == 0 || k==0 || totalNodes == 1)
            return  head;

        if ( k >= totalNodes) {
            k = k%totalNodes;
        }

        //means nothing to rotate
        if (k==0)
            return head;

        ListNode runningNode = head;

        //since we are starting from head, it's already counted
        int nodesToMoved = totalNodes-k-1;
        while (nodesToMoved > 0) {
            runningNode = runningNode.next;
            nodesToMoved--;
        }

        ListNode newHead = null;
        if (runningNode.next != null) {
            newHead = runningNode.next;
            runningNode.next = null;
        } else {
            newHead= runningNode;
        }

        ListNode movingPointer = newHead;
        while (movingPointer.next != null) {
            movingPointer = movingPointer.next;
        }
        movingPointer.next = head;

        return newHead;
    }

    public int getTotalNodes(ListNode head) {
        int count =0;

        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        return  count;
    }

    public static void printLL(ListNode head) {
        while ((head != null)) {
            System.out.print(head.val + ",");
            head= head.next;
        }
        System.out.println("");
    }
    public static void main(String args[]) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);


        ListRotateRight listRotateRight= new ListRotateRight();
        ListNode head = listRotateRight.rotateRight(node,2);
        printLL(head);

        node =new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);

        head = listRotateRight.rotateRight(node,4);
        printLL(head);

        node =new ListNode(0);
        node.next = new ListNode(1);

        head = listRotateRight.rotateRight(node,3);
        printLL(head);

        node =new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        head = listRotateRight.rotateRight(node,2000000000);
        printLL(head);

        node =new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        head = listRotateRight.rotateRight(node,10);
        printLL(head);

        System.out.println("");

    }
}
