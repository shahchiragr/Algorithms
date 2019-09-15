package org.cshah.algorithms.tree;

/**
 * Created by cshah on 5/8/14.
 */
public class KthLargestNodeInTree {
    int count=0;

    TreeNode Largest(TreeNode root, int k) {
        if (root == null)
            return  null;
        TreeNode right = Largest(root.getRight(), k);
        if (right !=  null)
            return  right;
        count++;
        if (count == k)
            return root;

        return Largest(root.getLeft(), k);
    }

    public static void main(String args[]) {
        TreeNode leftNode = new TreeNode(50, new TreeNode(25,null,null), new TreeNode(75,null,null));
        TreeNode rightNode = new TreeNode(150, new TreeNode(125,null,null), new TreeNode(175,null,null));
        TreeNode root = new TreeNode(100, leftNode, rightNode);

        KthLargestNodeInTree obj = new KthLargestNodeInTree();
        TreeNode treeNode = obj.Largest(root,3);
        System.out.println("TreeNode " + treeNode.getVal());


    }

}
