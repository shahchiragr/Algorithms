package org.cshah.algorithms.tree;

/**
 * Created by cshah on 4/23/14.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.val = value;
    }
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.val = value;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static void main(String args[]) {
        TreeNode leftNode = new TreeNode(50, new TreeNode(25,null,null), new TreeNode(75,null,null));
        TreeNode rightNode = new TreeNode(150, new TreeNode(125,null,null), new TreeNode(175,null,null));
        TreeNode root = new TreeNode(100, leftNode, rightNode);

    }
}
