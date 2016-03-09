package com.example.algorithms.linkedlist;

/**
 * Created by chirag on 11/25/14.
 */
public class ReverseAlternateNode {
    Node node = new Node(1,new Node(2, new Node(3, new Node(4, new Node(5, new Node(6,null))))));

    public void reverse() {


    }

    public static void main(String args[]) {

        ReverseAlternateNode reverseAlternateNode  = new ReverseAlternateNode();
        reverseAlternateNode.reverse();
    }
}
