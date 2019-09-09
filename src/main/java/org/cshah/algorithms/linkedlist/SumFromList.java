package org.cshah.algorithms.linkedlist;

public class SumFromList {

    public Node addTwoNumbers(Node l1, Node l2) {
        Node head = null ;
        Node currentNode = null;

        int carryForward= 0;

        while (l1 != null && l2 != null) {
            int sum = carryForward + l1.val + l2.val;

            Node listNode = new Node(sum > 9 ? sum-10 : sum);

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

            Node listNode = new Node(sum > 9 ? sum-10 : sum);

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

            Node listNode = new Node(sum > 9 ? sum-10 : sum);

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
            Node listNode = new Node(carryForward);
            currentNode.next = listNode;

        }

        return  head;
    }

    public  static void main(String[] args) {

    }
}
