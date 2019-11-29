package org.cshah.algorithms.ik.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class CheckBST {
    static boolean isBST(TreeNode root){
       return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBST(TreeNode root, int lowerBound, int upperBound){
        if (root == null)
            return  true;

       if (root.val < lowerBound  || root.val > upperBound )
           return false;

        boolean leftVal = isBST(root.left_ptr,lowerBound, root.val);
        boolean rightVal = isBST(root.right_ptr, root.val,upperBound);

        return (leftVal & rightVal);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 300;

        TreeNode left = new TreeNode();
        left.val = 200;

        TreeNode right = new TreeNode();
        right.val = 400;

        root.left_ptr = left;
        root.right_ptr = right;

        TreeNode left_1 = new TreeNode();
        left_1.val = 100;

        TreeNode right_1 = new TreeNode();
        right_1.val = 400;

        left.left_ptr = left_1;
        left.right_ptr = right_1;

        System.out.println("check " + CheckBST.isBST(root));

    }

}
