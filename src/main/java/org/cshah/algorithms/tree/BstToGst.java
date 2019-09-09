package org.cshah.algorithms.tree;

public class BstToGst {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null)
            return  null;

        TreeNode newTree = new TreeNode(root.val);
        newTree.right = bstToGst(root.right);

        newTree.val += sum;
        sum = newTree.val;


        newTree.left = bstToGst(root.left);

    return newTree;
    }



    public static void main(String[] args) {
        TreeNode treeNode = generateTree();
        printTree(treeNode);
        System.out.println("");
        BstToGst bstToGst = new BstToGst();
        TreeNode newNode = bstToGst.bstToGst(treeNode);

        printTree(newNode);
        System.out.println("");

    }

    public static void printTree(TreeNode node) {
        if (node == null)
            return;

        System.out.print(node.val + ",");
        printTree(node.left);
        printTree(node.right);
    }

    public static TreeNode generateTree() {
        TreeNode root = new BstToGst.TreeNode(4);
        TreeNode l1 = new TreeNode(1);
        TreeNode r6 = new TreeNode(6);
        root.left = l1;
        root.right = r6;

        TreeNode l0 = new TreeNode(0);
        TreeNode r2 = new TreeNode(2);
        l1.left = l0;
        l1.right = r2;

        TreeNode r3 = new TreeNode(3);
        r2.right = r3;

        TreeNode l5 = new TreeNode(5);
        TreeNode r7 = new TreeNode(7);

        r6.left= l5;
        r6.right = r7;

        TreeNode r8 = new TreeNode(8);
        r7.right= r8;



        return root;
    }
}
