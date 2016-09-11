package com.example.algorithms.tree;

/**
 * Created by cshah on 4/23/14.
 */
public class TreeWithLLNode {

    int value;
    TreeWithLLNode left;
    TreeWithLLNode right;

    TreeWithLLNode previous;
    TreeWithLLNode next;


    public TreeWithLLNode(int value) {
        this.value = value;
    }
    public TreeWithLLNode(int value, TreeWithLLNode left, TreeWithLLNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public TreeWithLLNode getLeft() {
        return left;
    }

    public TreeWithLLNode getRight() {
        return right;
    }

    public void setLeft(TreeWithLLNode left) {
        this.left = left;
    }

    public void setRight(TreeWithLLNode right) {
        this.right = right;
    }

    public TreeWithLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(TreeWithLLNode previous) {
        this.previous = previous;
    }

    public TreeWithLLNode getNext() {
        return next;
    }

    public void setNext(TreeWithLLNode next) {
        this.next = next;
    }


    public static void main(String args[]) {
        TreeWithLLNode leftNode = new TreeWithLLNode(50, new TreeWithLLNode(25,null,null), new TreeWithLLNode(75,null,null));
        TreeWithLLNode rightNode = new TreeWithLLNode(150, new TreeWithLLNode(125,null,null), new TreeWithLLNode(175,null,null));
        TreeWithLLNode root = new TreeWithLLNode(100, leftNode, rightNode);

    }
}
