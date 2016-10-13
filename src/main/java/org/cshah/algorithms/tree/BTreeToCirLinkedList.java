package org.cshah.algorithms.tree;

/**
 * Created by chirag on 9/10/16.
 * http://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list
 */

public class BTreeToCirLinkedList {


    public void inOrder(TreeWithLLNode node) {
        if (node == null)
            return;

        inOrder(node.getLeft());
        System.out.print(node.getValue() + " " );
        inOrder(node.getRight());
    }

    public TreeWithLLNode concatenate(TreeWithLLNode leftList,TreeWithLLNode rightList)
    {
        // If either of the list is empty, then
        // return the other list
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;

        // Store the last Node of left List
        TreeWithLLNode leftLast = leftList.previous;

        // Store the last Node of right List
        TreeWithLLNode rightLast = rightList.previous;

        // Connect the last node of Left List
        // with the first Node of the right List
        leftLast.next = rightList;
        rightList.previous = leftLast;

        // left of first node refers to
        // the last node in the list
        leftList.previous = rightLast;

        // Right of last node refers to the first
        // node of the List
        rightLast.next = leftList;

        // Return the Head of the List
        return leftList;
    }


    // Method converts a tree to a circular
    // Link List and then returns the head
    // of the Link List
    public TreeWithLLNode bTreeToCList(TreeWithLLNode root)
    {
        if (root == null)
            return null;

        // Recursively convert left and right subtrees
        TreeWithLLNode left = bTreeToCList(root.left);
        TreeWithLLNode right = bTreeToCList(root.right);

        // Make a circular linked list of single node
        // (or root). To do so, make the right and
        // left pointers of this node point to itself
        root.previous = root.next = root;

        // Step 1 (concatenate the left list with the list
        //         with single node, i.e., current node)
        // Step 2 (concatenate the returned list with the
        //         right List)A
        return concatenate(concatenate(left, root), right);
    }

    public static void main(String args[]) {
        TreeWithLLNode leftNode = new TreeWithLLNode(12, new TreeWithLLNode(25,null,null), new TreeWithLLNode(30,null,null));
        TreeWithLLNode rightNode = new TreeWithLLNode(15, new TreeWithLLNode(36,null,null),null);
        TreeWithLLNode root = new TreeWithLLNode(10, leftNode, rightNode);
        BTreeToCirLinkedList bTreeToCirLinkedList = new BTreeToCirLinkedList();

        bTreeToCirLinkedList.inOrder(root);
        System.out.println();

        TreeWithLLNode linkedList = bTreeToCirLinkedList.bTreeToCList(root);
        System.out.println();

    }
}
