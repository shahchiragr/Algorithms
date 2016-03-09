package com.example.algorithms.tree;

/**
 * Created by cshah on 4/23/14.
 */
public class CloneTree {

    public static Tree copyTree(Tree root) {
        if (root == null)
            return null;

        Tree newNode = new Tree(root.getValue());
        newNode.setLeft(copyTree(root.getLeft()));
        newNode.setRight(copyTree(root.getRight()));

        return newNode;
    }

    public static void printTree(Tree root) {
        if (root == null)
            return;

        System.out.print(root.getValue() + " : " );
        printTree(root.getLeft());
        printTree(root.getRight());

    }
    public static void main(String args[]) {
        Tree root = new Tree(100);
        root.setLeft(new Tree(50, new Tree(25), new Tree(75)));
        root.setRight(new Tree(150, new Tree(125), new Tree(175)));
        printTree(root);
        System.out.println("");
        Tree newNode = copyTree(root);
        printTree(newNode);


    }

}