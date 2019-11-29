package org.cshah.algorithms.ik.tree;

import org.cshah.algorithms.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class BST_KClosestNode {

    public static void kClosestNode(TreeNode root, int value, int k, Queue<TreeNode> queue) {
        if (root == null)
            return;;

            kClosestNode(root.left, value, k,queue);
            if (queue.size() < k) {
                queue.offer(root);
            } else {
                if ( Math.abs(root.val - value) < Math.abs(queue.peek().val -value) ) {
                    queue.poll();
                    queue.offer(root);
                }
            }

            kClosestNode(root.right, value, k, queue);
    }
    public static TreeNode getData() {
        TreeNode treeNode = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode12 = new TreeNode(12);

        treeNode.left =  treeNode5;
        treeNode.right = treeNode10;

        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;

        treeNode10.left = treeNode9;
        treeNode10.right = treeNode12;

        return treeNode;
    }
    public static void main(String[] args) {
        Queue<TreeNode> result = new ArrayDeque<TreeNode>();
        BST_KClosestNode.kClosestNode(getData(),7,3, result);

        for (TreeNode node : result) {
            System.out.println(node.val);
        }
    }
}
