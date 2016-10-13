package org.cshah.algorithms.tree;

/**
 * Created by cshah on 4/23/14.
 */
public class Tree {

    int value;
    Tree left;
    Tree right;

    public Tree(int value) {
        this.value = value;
    }
    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public static void main(String args[]) {
        Tree leftNode = new Tree(50, new Tree(25,null,null), new Tree(75,null,null));
        Tree rightNode = new Tree(150, new Tree(125,null,null), new Tree(175,null,null));
        Tree root = new Tree(100, leftNode, rightNode);

    }
}
