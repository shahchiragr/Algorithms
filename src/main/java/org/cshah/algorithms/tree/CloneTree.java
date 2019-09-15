package org.cshah.algorithms.tree;

/**
 * Created by cshah on 4/23/14.
 */
public class CloneTree {

    public static TreeNode copyTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode newNode = new TreeNode(root.getVal());
        newNode.setLeft(copyTree(root.getLeft()));
        newNode.setRight(copyTree(root.getRight()));

        return newNode;
    }

    public static void printTree(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.getVal() + " : " );
        printTree(root.getLeft());
        printTree(root.getRight());

    }
    public static void main(String args[]) {
        TreeNode root = new TreeNode(100);
        root.setLeft(new TreeNode(50, new TreeNode(25), new TreeNode(75)));
        root.setRight(new TreeNode(150, new TreeNode(125), new TreeNode(175)));
        printTree(root);
        System.out.println("");
        TreeNode newNode = copyTree(root);
        printTree(newNode);


    }

}