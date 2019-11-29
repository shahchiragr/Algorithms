package org.cshah.algorithms.ik.tree;

import java.util.Vector;

public class HeightOfKAryTree {
    static class TreeNode {
        int val;
        Vector<TreeNode> children = new Vector<TreeNode>(0);
        TreeNode() {
            children.clear();
        }
    };

    static int find_height(TreeNode root) {
        if (root == null)
            return  0;

        int height =0;
        for (int i=0; i < root.children.size(); i++) {
            int childHeight = 1 + find_height(root.children.get(i));
            height = Math.max(height, childHeight);
        }

        return  height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 100;
        for (int i=1;i<5;i++) {
            TreeNode child = new TreeNode();
            child.val = i;
            root.children.add(child);
        }

        TreeNode rootChild = root.children.get(0);
        for (int i=6;i<10;i++) {
            TreeNode child = new TreeNode();
            child.val = i;
            rootChild.children.add(child);
        }

        System.out.println(HeightOfKAryTree.find_height(root));
    }
}
