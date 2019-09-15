package org.cshah.algorithms.tree;

/**
 * Created by chirag on 9/3/16.
 */
public class BalancedTree {

    private static  int counter = 0;


//    =========================O(N^2) time ===================

    public static int getHeight(TreeNode root) {
        counter++;
        if  (root == null)
            return 0;

        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight()) ) +1;

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int heightDiff = getHeight(root.getLeft()) - getHeight(root.getRight()) ;

        System.out.println("Height Diff " + heightDiff);
        if (Math.abs(heightDiff) >1)
            return false;
        else
            return isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

//    =========================O(N) time and O(H) space ===================

    public static int checkHeight(TreeNode root) {
        counter++;
        if (root == null)
            return 0;

        System.out.println("Entering ListNode(" + root.getVal() + ")" );

        int leftHeight = checkHeight(root.getLeft());

        if (leftHeight == -1) {
            System.out.println("-1 at ListNode(" + root.getVal() + ")" );
            return -1;
        }

        int rightHeight = checkHeight(root.getRight());
        if (rightHeight == -1) {
            System.out.println("-1 at ListNode(" + root.getVal() + ")" );
            return -1;
        }

        System.out.println("height at ListNode(" + root.getVal() + "):" +  leftHeight + ":" + rightHeight);
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) +1;
    }

    public static boolean isBinaryTree(TreeNode root, int minValue, int maxValue) {
        if (root == null)
            return  true;

        if(root.getVal() < minValue || root.getVal() > maxValue)
            return  false;

        return isBinaryTree(root.getLeft(), minValue, root.getVal()) && isBinaryTree(root.getRight(), root.getVal(), maxValue);

    }
    public static boolean isBalancedNew(TreeNode root) {
        if (checkHeight(root) == -1)
            return  false;
        else
            return  true;
    }
        public static void main(String args[]) {
        TreeNode Node15 = new TreeNode(15, new TreeNode(5,null,null), new TreeNode(10,null,null));
        TreeNode Node25 = new TreeNode(25, Node15, new TreeNode(35,null,null));
        TreeNode Node50 = new TreeNode(50, Node25, new TreeNode(75,null,null));
        TreeNode Node150 = new TreeNode(150, new TreeNode(125,null,null), new TreeNode(175,null,null));
        TreeNode root100 = new TreeNode(100, Node50, Node150);


//        System.out.println("is Balanced : " +BalancedTree.isBalanced(root100));
//        System.out.println("counter " + counter);
//        counter =0;

        TreeNode leftNode = new TreeNode(50, new TreeNode(25,null,null), new TreeNode(75,null,null));
        TreeNode rightNode = new TreeNode(150, new TreeNode(125,null,null), new TreeNode(175,null,null));
        TreeNode root = new TreeNode(100, leftNode, rightNode);

//        System.out.println("is Balanced : " +BalancedTree.isBalanced(root));
//        System.out.println("counter " + counter);
//         counter =0;

        System.out.println("is Balanced : " +BalancedTree.isBalancedNew(root100));
        System.out.println("counter " + counter);
        counter =0;

            System.out.println("is Balanced : " +BalancedTree.isBalancedNew(root));
            System.out.println("counter " + counter);
            counter =0;

        System.out.println("is Binary TreeNode>>> " + BalancedTree.isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

            TreeNode leftNode1 = new TreeNode(50, new TreeNode(25,null,null), new TreeNode(175,null,null));
            TreeNode rightNode1 = new TreeNode(150, new TreeNode(125,null,null), new TreeNode(175,null,null));
            TreeNode root1 = new TreeNode(100, leftNode1, rightNode1);

            System.out.println("is Binary TreeNode>>> " + BalancedTree.isBinaryTree(root1, Integer.MIN_VALUE, Integer.MAX_VALUE));


             leftNode1 = new TreeNode(250, new TreeNode(200,null,new TreeNode(201,null,null)), new TreeNode(400,null,null));
             rightNode1 = new TreeNode(750, new TreeNode(600,null,null), new TreeNode(800,null,null));
             root1 = new TreeNode(500, leftNode1, rightNode1);

            System.out.println("is Binary TreeNode >>> " + BalancedTree.isBalancedNew(root1));

        }
}
