package com.example.algorithms.linkedlist;

/**
 * Created by cshah on 5/18/14.
 */
public class LinkedListNode {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public LinkedListNode(int value, LinkedListNode node) {
        this.value = value;
        this.next = node;
    }

    public static LinkedListNode getLinkedList() {
        LinkedListNode node = new LinkedListNode(1, new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, new LinkedListNode(3, new LinkedListNode(4, new LinkedListNode(5)))))));
        return node;
    }
}
