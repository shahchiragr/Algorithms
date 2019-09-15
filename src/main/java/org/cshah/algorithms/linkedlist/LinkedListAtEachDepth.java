package org.cshah.algorithms.linkedlist;

import org.cshah.algorithms.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by chirag on 9/4/16.
 */
public class LinkedListAtEachDepth {

    /***************************************************************************/
    /*
        Time Complexity for this Algo is O(N) - space Complexity O(log N) recursive call - this is depth first search (DFS)
        as it's traversing till depth
     */
    public static void createlevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> results, int level) {
        if (root == null)
            return;
        LinkedList<TreeNode> linkedList = null;

        if (results.size() == level) {
            linkedList = new LinkedList<TreeNode>();
            results.add(linkedList);
        } else {
            linkedList =results.get(level);
        }

        linkedList.add(root);

        createlevelLinkedList(root.getLeft(),results, level+1 );
        createlevelLinkedList(root.getRight(), results, level+1);

    }

    public static void createLevelLinkedList() {
        TreeNode treeNode = generateTree();
        ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<LinkedList<TreeNode>>();
        createlevelLinkedList(treeNode, arrayList,0);

        System.out.println("ArrayList Size... (Algo1) " + arrayList.size());
    }

    /***************************************************************************/

    /***************** This is BFS example ********************/
    public static void createLevelLinkedListAlgo2(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> resultList = new ArrayList<LinkedList<TreeNode>>();

        /* Visit the root */
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() >0 ) {
            resultList.add(current);

            LinkedList<TreeNode> parents = current;

            current = new LinkedList<TreeNode>();

            for (TreeNode treeNode : parents) {
                if (treeNode.getLeft() != null) {
                    current.add(treeNode.getLeft());
                }

                if (treeNode.getRight() != null) {
                    current.add(treeNode.getRight());
                }
            }//for

        } //while

        System.out.println("ArrayList Size... (Algo2) " + resultList.size());
    }

    /***************************************************************************/
    public static TreeNode generateTree() {
        TreeNode leftNode = new TreeNode(50, new TreeNode(25,null,null), new TreeNode(75,null,null));
        TreeNode rightNode = new TreeNode(150, new TreeNode(125,null,null), new TreeNode(175,null,null));
        TreeNode root = new TreeNode(100, leftNode, rightNode);
        return root;
    }


    public static void main(String args[]) {
        LinkedListAtEachDepth.createLevelLinkedList();

        LinkedListAtEachDepth.createLevelLinkedListAlgo2(generateTree());

    }
}
