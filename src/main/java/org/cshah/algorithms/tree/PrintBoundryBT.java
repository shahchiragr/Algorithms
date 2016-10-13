package org.cshah.algorithms.tree;

/**
 * Created by cshah on 4/23/14.
 */
public class PrintBoundryBT {

    public static void printLeftEdges(Tree node, boolean print) {
        if (node == null) return;

        if (print || ( node.getLeft() != null && node.getRight() != null)) {
            System.out.print(node.getValue() + " ");
        }

        printLeftEdges(node.getLeft(), print);
        printLeftEdges(node.getRight(), print && node.getLeft() != null ? true : false);

    }

    public static void printRightEdges(Tree node, boolean print) {
        if (node == null) return;

        printRightEdges(node.getLeft(),print && node.getRight() != null ? true :false);
        printRightEdges(node.getRight(), print);

        if (print || (node.getLeft() != null && node.getRight() != null))  {
            System.out.print(node.getValue() + " ");
        }
    }

    public static void printBoundary(Tree node) {
        if (node == null)
            return;

        System.out.print(node.getValue() + " ");
        printLeftEdges(node.getLeft(), true);
        printRightEdges(node.getRight(), true);

    }
    public static void main(String args[]) {
        Tree leftnode = new Tree(10, new Tree(50,null, null), null);
        Tree rightnode = new Tree(20, new Tree(45,null, null), new Tree(35, null, null));
        Tree root = new Tree(30, leftnode, rightnode);

        PrintBoundryBT.printBoundary(root);

        System.out.println();
        Tree ten = new Tree(10, new Tree(5, null,null), new Tree(15, null,null));
        Tree twentyfive = new Tree(25, null, new Tree(28, null,null));
        Tree twenty = new Tree(20, ten, twentyfive);
        Tree forty = new Tree(40, new Tree(35, null,null), new Tree(50, new Tree(41,null, null),null));
        Tree thirty = new Tree(30, twenty,forty);

        PrintBoundryBT.printBoundary(thirty);

    }
}
