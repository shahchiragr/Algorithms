package org.cshah.algorithms.tree;

/**
 * Created by chirag on 9/3/16.
 */
public class BalancedTree {

    private static  int counter = 0;


//    =========================O(N^2) time ===================

    public static int getHeight(Tree root) {
        counter++;
        if  (root == null)
            return 0;

        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight()) ) +1;

    }

    public static boolean isBalanced(Tree root) {
        if (root == null) return true;

        int heightDiff = getHeight(root.getLeft()) - getHeight(root.getRight()) ;

        System.out.println("Height Diff " + heightDiff);
        if (Math.abs(heightDiff) >1)
            return false;
        else
            return isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

//    =========================O(N) time and O(H) space ===================

    public static int checkHeight(Tree root) {
        counter++;
        if (root == null)
            return 0;

        System.out.println("Entering Node(" + root.getValue() + ")" );

        int leftHeight = checkHeight(root.getLeft());

        if (leftHeight == -1) {
            System.out.println("-1 at Node(" + root.getValue() + ")" );
            return -1;
        }

        int rightHeight = checkHeight(root.getRight());
        if (rightHeight == -1) {
            System.out.println("-1 at Node(" + root.getValue() + ")" );
            return -1;
        }

        System.out.println("height at Node(" + root.getValue() + "):" +  leftHeight + ":" + rightHeight);
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) +1;
    }

    public static boolean isBinaryTree(Tree root, int minValue, int maxValue) {
        if (root == null)
            return  true;

        if(root.getValue() < minValue || root.getValue() > maxValue)
            return  false;

        return isBinaryTree(root.getLeft(), minValue, root.getValue()) && isBinaryTree(root.getRight(), root.getValue(), maxValue);

    }
    public static boolean isBalancedNew(Tree root) {
        if (checkHeight(root) == -1)
            return  false;
        else
            return  true;
    }
        public static void main(String args[]) {
        Tree Node15 = new Tree(15, new Tree(5,null,null), new Tree(10,null,null));
        Tree Node25 = new Tree(25, Node15, new Tree(35,null,null));
        Tree Node50 = new Tree(50, Node25, new Tree(75,null,null));
        Tree Node150 = new Tree(150, new Tree(125,null,null), new Tree(175,null,null));
        Tree root100 = new Tree(100, Node50, Node150);


//        System.out.println("is Balanced : " +BalancedTree.isBalanced(root100));
//        System.out.println("counter " + counter);
//        counter =0;

        Tree leftNode = new Tree(50, new Tree(25,null,null), new Tree(75,null,null));
        Tree rightNode = new Tree(150, new Tree(125,null,null), new Tree(175,null,null));
        Tree root = new Tree(100, leftNode, rightNode);

//        System.out.println("is Balanced : " +BalancedTree.isBalanced(root));
//        System.out.println("counter " + counter);
//         counter =0;

        System.out.println("is Balanced : " +BalancedTree.isBalancedNew(root100));
        System.out.println("counter " + counter);
        counter =0;

            System.out.println("is Balanced : " +BalancedTree.isBalancedNew(root));
            System.out.println("counter " + counter);
            counter =0;

        System.out.println("is Binary Tree>>> " + BalancedTree.isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

            Tree leftNode1 = new Tree(50, new Tree(25,null,null), new Tree(175,null,null));
            Tree rightNode1 = new Tree(150, new Tree(125,null,null), new Tree(175,null,null));
            Tree root1 = new Tree(100, leftNode1, rightNode1);

            System.out.println("is Binary Tree>>> " + BalancedTree.isBinaryTree(root1, Integer.MIN_VALUE, Integer.MAX_VALUE));


             leftNode1 = new Tree(250, new Tree(200,null,new Tree(201,null,null)), new Tree(400,null,null));
             rightNode1 = new Tree(750, new Tree(600,null,null), new Tree(800,null,null));
             root1 = new Tree(500, leftNode1, rightNode1);

            System.out.println("is Binary Tree >>> " + BalancedTree.isBalancedNew(root1));

        }
}
