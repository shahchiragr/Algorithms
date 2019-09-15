package org.cshah.algorithms.leetcode.medium;

import org.cshah.algorithms.tree.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTree {

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null) {
            flatten(root.left);
            TreeNode rightNode = root.right;
            root.right = root.left;
            root.left = null;

            while (root.right != null) {
                root = root.right;
            }

            root.right = rightNode;

        }

        if (root.right != null) {
            flatten(root.right);
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();
        flattenBinaryTree.flatten(treeNode);

        TreeNode head = treeNode;
        while ( head != null) {
            System.out.print(head.val + "  ");
            head = head.right;
        }
        System.out.println();
    }
}
