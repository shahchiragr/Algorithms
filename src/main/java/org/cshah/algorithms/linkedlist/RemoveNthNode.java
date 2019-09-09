package org.cshah.algorithms.linkedlist;

public class RemoveNthNode {

    public Node removeNthFromEnd(Node head, int n) {
        int counter =1;

        if (head == null)
            return  head;

        if (head.next == null && n >= 1)
            return null;

        Node tail = head;

        Node current = head;
        Node previous = null;

        while (tail != null && counter <= n ) {
            tail = tail.next;
            counter++;
        }

        Node resultNode = null;

        while (tail != null) {
            previous = current;
            current = current.next;
            if (resultNode == null) {
                resultNode = previous;
            }
            tail = tail.next;
        }

        if (current != null) {
            if (previous == null) {
                previous = current.next;
                if (resultNode == null) {
                    resultNode = previous;
                }
            } else {
                previous.next = current.next;
            }
        } else  {
            previous.next =null;
            resultNode = previous;
        }

        return  resultNode;
    }

    public static void main(String[] args) {
        RemoveNthNode removeNthNode = new RemoveNthNode();
        Node result = null;
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        result = removeNthNode.removeNthFromEnd(listNode1, 2);
//        while (result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }
//
//
//        ListNode listNode11 = new ListNode(1);
//        result = removeNthNode.removeNthFromEnd(listNode11, 1);
//        while (result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }


        Node listNode111 = new Node(1);
        Node listNode222 = new Node(2);
        listNode111.next = listNode222;
        result = removeNthNode.removeNthFromEnd(listNode111, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
