package com.example.algorithms.linkedlist;

/**
 * Created by chirag on 11/25/14.
 */
public class Node {
    int i;
    Node next;

    public Node (int i ) {
        this(i,null);
    }
    public Node (int i, Node n) {
        this.i = i;
        this.next = n;
    }


}
