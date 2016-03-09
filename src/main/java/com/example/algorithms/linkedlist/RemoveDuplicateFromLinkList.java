package com.example.algorithms.linkedlist;

import com.example.algorithms.linkedlist.LinkedListNode;

/**
 * Created by cshah on 5/18/14.
 */
public class RemoveDuplicateFromLinkList {

    public static void deleteDupNode(LinkedListNode head) {
        if (head == null) return;

        LinkedListNode previous = head;
        LinkedListNode current = previous.next;

        while (current != null) {
            LinkedListNode runner = head;
          while ( runner != current && runner != null && current != null) {

            if (runner.value == current.value) {
                LinkedListNode tmp = current.next;
                previous.next = tmp;
                current = tmp;
                break;
            }

            runner = runner.next;

              if (runner == current) {
                  previous = current;
                  current = current.next;
              }

        }  //while

        }
    }

    public static void printNode(LinkedListNode head) {
        while (head != null) {
            System.out.print(head.value + "-->");
            head = head.next;
        }

        System.out.println();
    }
    public static void main(String args[]) {
        LinkedListNode head = LinkedListNode.getLinkedList();
        printNode(head);
        deleteDupNode(head);
        printNode(head);
    }
}
