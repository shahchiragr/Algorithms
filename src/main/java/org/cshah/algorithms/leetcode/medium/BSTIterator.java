package org.cshah.algorithms.leetcode.medium;

import org.cshah.algorithms.tree.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        if (root == null)
            return;

        initStack(root);
    }

    private void initStack(TreeNode root) {
        stack.push(root);
        TreeNode head = root;
        while (head.left != null) {
            stack.push(head.left);
            head = head.left;
        }
    }
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            stack.push(node.right);
            TreeNode head = node.right;
            while (head.left != null) {
                stack.push(head.left);
                head = head.left;
            }
        }
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void SOP(Object str) {
        System.out.println(str.toString());
    }
    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(9);
        treeNode.right.right = new TreeNode(20);

        BSTIterator bstIterator = new BSTIterator(treeNode);
        SOP(bstIterator.hasNext());
        SOP(bstIterator.next());
        SOP(bstIterator.next());
        SOP(bstIterator.next());
        SOP(bstIterator.next());
        SOP(bstIterator.hasNext());
        SOP(bstIterator.next());
        SOP(bstIterator.hasNext());
    }
}