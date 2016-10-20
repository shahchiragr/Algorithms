package org.cshah.algorithms.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by chirag on 10/13/16.
 */
public class BTreeLinkedListEachLevel {

    /**
     * Uses o log (N) recursive call
     * @param root
     * @param list
     * @param level
     */
    public void bTreeToLinkedList(TreeWithLLNode root, ArrayList<LinkedList<TreeWithLLNode>> list, int level) {
        if (root == null)
            return;

        LinkedList<TreeWithLLNode> childList;
        if (list.size() == level) {
            childList = new LinkedList<TreeWithLLNode>();
            list.add(level,childList);
        } else {
            childList = list.get(level);
        }

        childList.add(root);
        bTreeToLinkedList(root.getLeft(), list, level+1);
        bTreeToLinkedList(root.getRight(), list, level+1);

    }

    /**
     * runs in O(N) Time
     * @param root
     * @param list
     */
    public void bTreeToLinkedListIterative(TreeWithLLNode root, ArrayList<LinkedList<TreeWithLLNode>> list) {
        LinkedList<TreeWithLLNode> current = new LinkedList<TreeWithLLNode>();

        if (root != null) {
            current.add(root);
        }

        while (current.size() >0) {
            list.add(current);
            LinkedList<TreeWithLLNode> parents = current;
            current = new LinkedList<TreeWithLLNode>();

            for (TreeWithLLNode parentNode : parents) {
                if (parentNode.getLeft() != null) {
                    current.add(parentNode.getLeft());
                }

                if (parentNode.getRight() != null) {
                    current.add(parentNode.getRight());
                }
            }//for

        }//while
    }

    public static void main(String args[]) {
        TreeWithLLNode leftNode = new TreeWithLLNode(500, new TreeWithLLNode(250,null,null), new TreeWithLLNode(750,null,null));
        TreeWithLLNode rightNode = new TreeWithLLNode(1500, new TreeWithLLNode(1250,null,null),new TreeWithLLNode(1750,null,null));
        TreeWithLLNode root = new TreeWithLLNode(1000, leftNode, rightNode);

        BTreeLinkedListEachLevel bTreeLinkedListEachLevel = new BTreeLinkedListEachLevel();
        ArrayList<LinkedList<TreeWithLLNode>> list = new ArrayList<LinkedList<TreeWithLLNode>>();


//        bTreeLinkedListEachLevel.bTreeToLinkedList(root, list,0);

        bTreeLinkedListEachLevel.bTreeToLinkedListIterative(root, list);

        System.out.println("LIST " + list.size());

    }
}
