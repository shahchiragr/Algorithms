package org.cshah.algorithms.linkedlist;

/**
 * Created by chirag on 10/12/16.
 */
public class KthToLastElement {

    static int count = 0;
    public static Node getkthToLast(Node node, int k) {
        if (node == null)
            return  null;

        Node node1=  getkthToLast(node.next, k);
         count++;

        if (count == k)
            return node;


        return  node1;
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next = new Node(5);
        n.next.next.next.next.next = new Node(6);
        n.next.next.next.next.next.next = new Node(7);
        n.next.next.next.next.next.next.next = new Node(8);
        n.next.next.next.next.next.next.next.next = new Node(9);

        int k = 3;
        System.out.println(k + "th to last element is " + KthToLastElement.getkthToLast(n, k).i);

    }
}
