package org.cshah.algorithms.linkedlist;

/**
 * Created by chirag on 9/20/16.
 */
public class ReverseAlternativeKNode {

        static Node head;
    // Java program to reverse alternate k nodes in a linked list

        /* Reverses alternate k nodes and
         returns the pointer to the new head node */
        public Node kAltReverse(Node node, int k) {
            Node current = node;
            Node next = null, prev = null;
            int count = 0;

        /*1) reverse first k nodes of the linked list */
            while (current != null && count < k) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

        /* 2) Now head points to the kth node.  So change next
         of head to (k+1)th node*/
            if (node != null) {
                node.next = current;
            }

        /* 3) We do not want to reverse next k nodes. So move the current
         pointer to skip next k nodes */
            count = 0;
            while (count < k - 1 && current != null) {
                current = current.next;
                count++;
            }

        /* 4) Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
            if (current != null) {
                current.next = kAltReverse(current.next, k);
            }

        /* 5) prev is new head of the input list */
            return prev;
        }

        void printList(Node node) {
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
        }

        void push(int newdata) {
            Node mynode = new Node(newdata);
            mynode.next = head;
            head = mynode;
        }

        public static void main(String[] args) {
            ReverseAlternativeKNode reverseAlternativeKNode = new ReverseAlternativeKNode();

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
            reverseAlternativeKNode.printList(head);
            head = reverseAlternativeKNode.kAltReverse(head, 3);
            System.out.println("");
            System.out.println("Modified Linked List :");
            reverseAlternativeKNode.printList(head);

        }


// This code has been contributed by Mayank Jaiswal
}
