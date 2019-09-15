package org.cshah.algorithms.linkedlist;

public class SumFromList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null ;
        ListNode currentNode = null;

        int carryForward= 0;

        while (l1 != null && l2 != null) {
            int sum = carryForward + l1.val + l2.val;

            ListNode listNode = new ListNode(sum > 9 ? sum-10 : sum);

            carryForward = sum > 9 ? 1 : 0;

            if (head == null) {
                head = listNode;
            } else {
                currentNode.next = listNode;
            }
            currentNode = listNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null ) {
            int sum = carryForward + l1.val;

            ListNode listNode = new ListNode(sum > 9 ? sum-10 : sum);

            carryForward = sum > 9 ? 1 : 0;

            if (head == null) {
                head = listNode;
            } else {
                currentNode.next = listNode;
            }
            currentNode = listNode;
            l1 = l1.next;
        }

        while (l2 != null ) {
            int sum = carryForward + l2.val;

            ListNode listNode = new ListNode(sum > 9 ? sum-10 : sum);

            carryForward = sum > 9 ? 1 : 0;

            if (head == null) {
                head = listNode;
            } else {
                currentNode.next = listNode;
            }
            currentNode = listNode;
            l2 = l2.next;
        }

        if (carryForward > 0) {
            ListNode listNode = new ListNode(carryForward);
            currentNode.next = listNode;

        }

        return  head;
    }

    public  static void main(String[] args) {

    }
}
