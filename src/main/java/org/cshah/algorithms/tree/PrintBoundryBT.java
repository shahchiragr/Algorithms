package org.cshah.algorithms.tree;

/**
 * Created by cshah on 4/23/14.
 */
public class PrintBoundryBT {

    public static void printLeftEdges(TreeNode node, boolean print) {
        if (node == null) return;

        if (print || ( node.getLeft() != null && node.getRight() != null)) {
            System.out.print(node.getVal() + " ");
        }

        printLeftEdges(node.getLeft(), print);
        printLeftEdges(node.getRight(), print && node.getLeft() != null ? true : false);

    }

    public static void printRightEdges(TreeNode node, boolean print) {
        if (node == null) return;

        printRightEdges(node.getLeft(),print && node.getRight() != null ? true :false);
        printRightEdges(node.getRight(), print);

        if (print || (node.getLeft() != null && node.getRight() != null))  {
            System.out.print(node.getVal() + " ");
        }
    }

    public static void printBoundary(TreeNode node) {
        if (node == null)
            return;

        System.out.print(node.getVal() + " ");
        printLeftEdges(node.getLeft(), true);
        printRightEdges(node.getRight(), true);

    }
    public static void main(String args[]) {
        TreeNode leftnode = new TreeNode(10, new TreeNode(50,null, null), null);
        TreeNode rightnode = new TreeNode(20, new TreeNode(45,null, null), new TreeNode(35, null, null));
        TreeNode root = new TreeNode(30, leftnode, rightnode);

        PrintBoundryBT.printBoundary(root);

        System.out.println();
        TreeNode ten = new TreeNode(10, new TreeNode(5, null,null), new TreeNode(15, null,null));
        TreeNode twentyfive = new TreeNode(25, null, new TreeNode(28, null,null));
        TreeNode twenty = new TreeNode(20, ten, twentyfive);
        TreeNode forty = new TreeNode(40, new TreeNode(35, null,null), new TreeNode(50, new TreeNode(41,null, null),null));
        TreeNode thirty = new TreeNode(30, twenty,forty);

        PrintBoundryBT.printBoundary(thirty);

    }
}
