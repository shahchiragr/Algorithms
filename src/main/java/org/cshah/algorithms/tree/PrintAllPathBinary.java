package org.cshah.algorithms.tree;

import java.util.Stack;

/**
 * Created by cshah on 5/5/14.
 */
public class PrintAllPathBinary {

    public static Tree getTree() {
        Tree leftNode = new Tree(50, new Tree(25,null,null), new Tree(75,null,null));
        Tree rightNode = new Tree(150, new Tree(125,null,null), new Tree(175,null,null));
        Tree root = new Tree(100, leftNode, rightNode);
        return root;
    }

    public static  void printBinaryPath(Tree root, Stack<Tree> path) {
        if (root == null)
            return;

        for (Tree n : path) {
            System.out.print(n.getValue() + "," );
        }
        System.out.println();

        if (root.getLeft() != null) {
            path.push(root.getLeft());
            printBinaryPath(root.getLeft(), path);
            path.pop();
        }

        if (root.getRight() != null) {
            path.push(root.getRight());
            printBinaryPath(root.getRight(), path);
            path.pop();
        }

    }

    public static void main(String args[]) {

        Stack<Tree> path = new Stack<Tree>();
        Tree root = getTree();
        path.push(root);
        printBinaryPath(root,path);

    }
}
