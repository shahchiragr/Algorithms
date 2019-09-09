package org.cshah.algorithms.linkedlist;

/**
 * Created by chirag on 11/25/14.
 */
public class Node {
    int val;
    Node next;

    public Node (int val) {
        this(val,null);
    }
    public Node (int val, Node n) {
        this.val = val;
        this.next = n;
    }


}
