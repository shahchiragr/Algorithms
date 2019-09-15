package org.cshah.algorithms.tree;

/**
 * Created by cshah on 4/23/14.
 */

import java.util.Stack;

public class BinaryTreeSize {

    public TreeNode generateNode() {
        TreeNode rootNode = new TreeNode(100);

        TreeNode lc = new TreeNode(50, new TreeNode(25), new TreeNode(75));
        TreeNode rc = new TreeNode(150, new TreeNode(125), new TreeNode(175));
        rootNode.setLeft(lc);
        rootNode.setRight(rc);

        return rootNode;
    }

    public void preOrder(TreeNode root) {
        if (root == null)
            return;

        preOrder(root.getLeft());
        System.out.print(root.getVal() + " ");
        preOrder(root.getRight());
       // System.out.println("");
    }


    public void inOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.getVal() + " ");
        inOrder(root.getLeft());
        inOrder(root.getRight());
        //System.out.println("");
    }

    public void postOrder(TreeNode root) {
        if (root == null)
            return;

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getVal() + " ");
        //System.out.println("");
    }
/***********************************************************************/
    public int size(TreeNode root) {
        if (root == null)
            return 0;

        return (size(root.getLeft()) + size(root.getRight()) +1);
    }

/***********************************************************************/
    public int minLevel(TreeNode root) {
        if (root == null)
            return 0;

        int level = 1 + Math.min(minLevel(root.getLeft()), minLevel(root.getRight()));
        return level;
    }

/***********************************************************************/
    public int maxLevel(TreeNode root) {
        if (root == null)
            return 0;

        int level = 1 + Math.max(maxLevel(root.getLeft()), maxLevel(root.getRight()));
        return level;
    }

/***********************************************************************/
    public boolean leftLevelTree(TreeNode root, int value) {
        if (root == null)
            return true;

        if (root.getLeft() != null && (root.getVal() < root.getLeft().getVal()))
            return false;

        if (root.getRight() != null && (root.getVal() > root.getRight().getVal()) )
            return false;

        if (root.getVal() > value)
            return false;

        return (leftLevelTree(root.getLeft(), value) && leftLevelTree(root.getRight(), value));
    }

    public boolean rightLevelTree(TreeNode root, int value) {
        if (root == null)
            return true;

        if (root.getLeft() != null && (root.getVal() < root.getLeft().getVal()))
            return false;

        if (root.getRight() != null && (root.getVal() > root.getRight().getVal()) )
            return false;

        if (root.getVal() < value)
            return false;

        return (rightLevelTree(root.getLeft(), value) && rightLevelTree(root.getRight(), value));
    }

    public boolean isBinaryTree(TreeNode root) {
        if (root == null)
            return true;

        int value = root.getVal();

        return leftLevelTree(root.getLeft(), value) && rightLevelTree(root.getRight(), value);
    }

/***********************************************************************/
    public int sum(TreeNode root) {
        if (root == null)
            return 0;

        return (sum(root.getLeft()) + sum(root.getRight()) + root.getVal());
    }
/***********************************************************************/

    public boolean isBinaryTree(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        return ((root.getVal() > min && root.getVal() < max) &&
                (isBinaryTree(root.getLeft(), min, root.getVal())) &&
                (isBinaryTree(root.getRight(), root.getVal(), max)) );

    }
/***********************************************************************/
    public boolean validateBST(TreeNode root) {
        TreeNode currNode = root;
        TreeNode prevNode = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (true) {
            if (currNode != null) {
                stack.push(currNode);
                currNode = currNode.getLeft();
                continue;
            }

            if (stack.isEmpty())
                return true;

            currNode = stack.pop();

            if (prevNode != null) {
                if (currNode.getVal() < prevNode.getVal())
                    return false;
            }

            prevNode = currNode;
            currNode = currNode.getRight();
        }//while
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTreeSize obj = new BinaryTreeSize();
        System.out.println("SIZE : " + obj.size(obj.generateNode()));

        System.out.println("MIN & MAX LEVEL : " + obj.minLevel(obj.generateNode()) + ":" + obj.maxLevel(obj.generateNode()));

        long stime = System.nanoTime();
        System.out.println("Is Binary TreeNode 1 " + obj.isBinaryTree(obj.generateNode()));
        long etime = System.nanoTime();
        System.out.println("TIME " + (etime - stime));

        stime = System.nanoTime();
        System.out.println("Is Binary TreeNode 2 " + obj.isBinaryTree(obj.generateNode(),0, Integer.MAX_VALUE));
        etime = System.nanoTime();
        System.out.println("TIME " + (etime - stime));

        stime = System.nanoTime();
        System.out.println("Is Binary TreeNode 3 " + obj.validateBST(obj.generateNode()));
        etime = System.nanoTime();
        System.out.println("TIME " + (etime - stime));

        System.out.println("PRE ORDER ");
        obj.preOrder(obj.generateNode());
        System.out.println();

        System.out.println("IN ORDER ");
        obj.inOrder(obj.generateNode());
        System.out.println();

        System.out.println("POST ORDER ");
        obj.postOrder(obj.generateNode());
        System.out.println();

        System.out.println("SUM " + obj.sum(obj.generateNode()));
    }

}