package org.cshah.algorithms.linkedlist;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chirag on 9/20/16.
 */
public class ReverseLinkedList {
    static Node head;

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    Node reverseLinkedList(Node node) {
        Node curr, prev,next;
        prev = null;
        curr = node;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    /********************************** Recursive Approach ************************************************/
    void  reverseLinkedListRecurr(Node curr, Node prev) {
        if (curr == null)
            return;

        reverseLinkedListRecurr(curr.next, curr);

        if (curr.next == null) {
            head = curr;
        }
            curr.next = prev;
    }

    static Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        Node node = new Node(data);
        if (head == null || position ==0) {
            head = node;
            return head;
        }

        Node pointer = head;
        int counter =0;
        Node prev = null;
        while (counter < position && pointer != null) {
            prev = pointer;
            pointer = pointer.next;
            counter++;
        }

        node.next = pointer;
        prev.next= node;

        return head;

    }

    static int GetNodeWithStack(Node head,int n) {
        Stack<Integer> stack = new Stack<Integer>();

        while (head != null) {
            stack.push(head.val);
        }

        int counter = 0;
        while (counter != n && !stack.isEmpty()) {
            stack.pop();
            counter++;
        }


        return stack.pop();
    }


    static int GetNode(Node head,int n) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        Node nn = getNodeRec(head, new AtomicInteger(0), n);

        System.out.println("OUTPUT IS " + nn.val);
        return nn.val;

    }

    static Node getNodeRec(Node head, AtomicInteger counter, int n) {
        if (head == null) {
            counter.set(-1);
            return null;
        }

        Node head1 = getNodeRec(head.next, counter, n);

        counter.incrementAndGet();

        if (counter.get() == n) {
            return head;
        }

        if (head1 != null)
            return head1;

        return null;
    }


    public static void main(String[] args) {
        ReverseLinkedList object = new ReverseLinkedList();


        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next = new Node(5);
        n.next.next.next.next.next = new Node(6);
        n.next.next.next.next.next.next = new Node(7);
        n.next.next.next.next.next.next.next = new Node(8);
        n.next.next.next.next.next.next.next.next = new Node(9);

        head = n;

        System.out.println("Given Linked List :");
        object.printList(head);
        head = object.reverseLinkedList(head);
        System.out.println("");
        System.out.println("Modified Linked List :");
        object.printList(head);
        object.reverseLinkedListRecurr(head, null);
        System.out.println("");
        System.out.println("Modified Linked List :");
        object.printList(head);


        Node head1 = ReverseLinkedList.InsertNth(null,3,0);
        head1 = ReverseLinkedList.InsertNth(head1,5,1);
        object.printList(head1);
        System.out.println("");

        head1 = ReverseLinkedList.InsertNth(head1,4,2);
        object.printList(head1);
        System.out.println("");

        head1 = ReverseLinkedList.InsertNth(head1,2,3);
        object.printList(head1);
        System.out.println("");

        head1 = ReverseLinkedList.InsertNth(head1,10,1);
        object.printList(head1);
        System.out.println("");

        ReverseLinkedList.GetNode(head,3);


    }


}
