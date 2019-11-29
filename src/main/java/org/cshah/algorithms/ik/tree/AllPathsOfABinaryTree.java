package org.cshah.algorithms.ik.tree;

import java.util.ArrayList;
import java.util.List;

public class AllPathsOfABinaryTree {

    static List<List<Integer>> allPathsOfABinaryTree(TreeNode root){
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null)
            return results;

        allPathsOfABinaryTreeRec(root, new ArrayList<Integer>(), results);
        return results;
     }

    static void allPathsOfABinaryTreeRec(TreeNode root, List<Integer> list, List<List<Integer>> results){
        if (root.left_ptr ==null && root.right_ptr == null ) {
            list.add(root.val);
            results.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        list.add(root.val);

        if (root.left_ptr != null)
            allPathsOfABinaryTreeRec(root.left_ptr, list, results);

        if (root.right_ptr != null)
          allPathsOfABinaryTreeRec(root.right_ptr, list, results);

        list.remove(list.size()-1);
    }

    public static TreeNode constructTree() {
        TreeNode root = new TreeNode();
        root.val = 10;

        TreeNode n20 = new TreeNode();
        n20.val = 20;

        TreeNode n30 = new TreeNode();
        n30.val = 30;

        TreeNode n40 = new TreeNode();
        n40.val = 40;

        TreeNode n50 = new TreeNode();
        n50.val = 50;

        root.left_ptr = n20;
        root.right_ptr = n30;

        n20.left_ptr = n40;
        n20.right_ptr = n50;

        return root;
    }
    public static void main(String[] args) {
        List<List<Integer>> results = AllPathsOfABinaryTree.allPathsOfABinaryTree(constructTree());
        for (List<Integer> dataList : results) {
            for (Integer val :dataList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}
