package com.example.algorithms.linkedlist;

import com.example.algorithms.tree.Tree;

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
    public static void createlevelLinkedList(Tree root, ArrayList<LinkedList<Tree>> results, int level) {
        if (root == null)
            return;
        LinkedList<Tree> linkedList = null;

        if (results.size() == level) {
            linkedList = new LinkedList<Tree>();
            results.add(linkedList);
        } else {
            linkedList =results.get(level);
        }

        linkedList.add(root);

        createlevelLinkedList(root.getLeft(),results, level+1 );
        createlevelLinkedList(root.getRight(), results, level+1);

    }

    public static void createLevelLinkedList() {
        Tree tree = generateTree();
        ArrayList<LinkedList<Tree>> arrayList = new ArrayList<LinkedList<Tree>>();
        createlevelLinkedList(tree, arrayList,0);

        System.out.println("ArrayList Size... (Algo1) " + arrayList.size());
    }

    /***************************************************************************/

    /***************** This is BFS example ********************/
    public static void createLevelLinkedListAlgo2(Tree root) {
        ArrayList<LinkedList<Tree>> resultList = new ArrayList<LinkedList<Tree>>();

        /* Visit the root */
        LinkedList<Tree> current = new LinkedList<Tree>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() >0 ) {
            resultList.add(current);

            LinkedList<Tree> parents = current;

            current = new LinkedList<Tree>();

            for (Tree tree : parents) {
                if (tree.getLeft() != null) {
                    current.add(tree.getLeft());
                }

                if (tree.getRight() != null) {
                    current.add(tree.getRight());
                }
            }//for

        } //while

        System.out.println("ArrayList Size... (Algo2) " + resultList.size());
    }

    /***************************************************************************/
    public static Tree generateTree() {
        Tree leftNode = new Tree(50, new Tree(25,null,null), new Tree(75,null,null));
        Tree rightNode = new Tree(150, new Tree(125,null,null), new Tree(175,null,null));
        Tree root = new Tree(100, leftNode, rightNode);
        return root;
    }


    public static void main(String args[]) {
        LinkedListAtEachDepth.createLevelLinkedList();

        LinkedListAtEachDepth.createLevelLinkedListAlgo2(generateTree());

    }
}
