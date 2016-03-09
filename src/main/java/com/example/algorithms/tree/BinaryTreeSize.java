package com.example.algorithms.tree;

/**
 * Created by cshah on 4/23/14.
 */

import java.util.Stack;

public class BinaryTreeSize {

    public Tree generateNode() {
        Tree rootNode = new Tree(100);

        Tree lc = new Tree(50, new Tree(25), new Tree(75));
        Tree rc = new Tree(150, new Tree(125), new Tree(175));
        rootNode.setLeft(lc);
        rootNode.setRight(rc);

        return rootNode;
    }

    public void preOrder(Tree root) {
        if (root == null)
            return;

        preOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        preOrder(root.getRight());
       // System.out.println("");
    }


    public void inOrder(Tree root) {
        if (root == null)
            return;

        System.out.print(root.getValue() + " ");
        inOrder(root.getLeft());
        inOrder(root.getRight());
        //System.out.println("");
    }

    public void postOrder(Tree root) {
        if (root == null)
            return;

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() + " ");
        //System.out.println("");
    }
/***********************************************************************/
    public int size(Tree root) {
        if (root == null)
            return 0;

        return (size(root.getLeft()) + size(root.getRight()) +1);
    }

/***********************************************************************/
    public int minLevel(Tree root) {
        if (root == null)
            return 0;

        int level = 1 + Math.min(minLevel(root.getLeft()), minLevel(root.getRight()));
        return level;
    }

/***********************************************************************/
    public int maxLevel(Tree root) {
        if (root == null)
            return 0;

        int level = 1 + Math.max(maxLevel(root.getLeft()), maxLevel(root.getRight()));
        return level;
    }

/***********************************************************************/
    public boolean leftLevelTree(Tree root, int value) {
        if (root == null)
            return true;

        if (root.getLeft() != null && (root.getValue() < root.getLeft().getValue()))
            return false;

        if (root.getRight() != null && (root.getValue() > root.getRight().getValue()) )
            return false;

        if (root.getValue() > value)
            return false;

        return (leftLevelTree(root.getLeft(), value) && leftLevelTree(root.getRight(), value));
    }

    public boolean rightLevelTree(Tree root, int value) {
        if (root == null)
            return true;

        if (root.getLeft() != null && (root.getValue() < root.getLeft().getValue()))
            return false;

        if (root.getRight() != null && (root.getValue() > root.getRight().getValue()) )
            return false;

        if (root.getValue() < value)
            return false;

        return (rightLevelTree(root.getLeft(), value) && rightLevelTree(root.getRight(), value));
    }

    public boolean isBinaryTree(Tree root) {
        if (root == null)
            return true;

        int value = root.getValue();

        return leftLevelTree(root.getLeft(), value) && rightLevelTree(root.getRight(), value);
    }

/***********************************************************************/
    public int sum(Tree root) {
        if (root == null)
            return 0;

        return (sum(root.getLeft()) + sum(root.getRight()) + root.getValue());
    }
/***********************************************************************/

    public boolean isBinaryTree(Tree root, int min, int max) {
        if (root == null)
            return true;

        return ((root.getValue() > min && root.getValue() < max) &&
                (isBinaryTree(root.getLeft(), min, root.getValue())) &&
                (isBinaryTree(root.getRight(), root.getValue(), max)) );

    }
/***********************************************************************/
    public boolean validateBST(Tree root) {
        Tree currNode = root;
        Tree prevNode = null;
        Stack<Tree> stack = new Stack<Tree>();

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
                if (currNode.getValue() < prevNode.getValue())
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
        System.out.println("Is Binary Tree 1 " + obj.isBinaryTree(obj.generateNode()));
        long etime = System.nanoTime();
        System.out.println("TIME " + (etime - stime));

        stime = System.nanoTime();
        System.out.println("Is Binary Tree 2 " + obj.isBinaryTree(obj.generateNode(),0, Integer.MAX_VALUE));
        etime = System.nanoTime();
        System.out.println("TIME " + (etime - stime));

        stime = System.nanoTime();
        System.out.println("Is Binary Tree 3 " + obj.validateBST(obj.generateNode()));
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