package org.cshah.algorithms.leetcode.medium;

import org.cshah.algorithms.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if  (preorder.length == 0 || inorder.length == 0)
            return  null;

        Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();

        for (int i=0; i < preorder.length;i++) {
            inOrderMap.put(inorder[i],i);
        }

        TreeNode root = null;
        root = buildTreeRec(preorder, inOrderMap, 0,preorder.length-1, 0, preorder.length-1);
        return root;
    }

    public TreeNode buildTreeRec(int[] preorder, Map<Integer, Integer> inOrderMap,
                                int pL, int pR, int iL, int iR) {
       if (pL > pR || pL < 0)
           return  null;

        if (pL == pR) {
            return new TreeNode(preorder[pL]);
        }

        int itemToFind = preorder[pL];
        TreeNode node = new TreeNode(itemToFind);
        int midIndex = inOrderMap.get(itemToFind);
        int leftIndex = midIndex - iL;
        node.left = buildTreeRec(preorder, inOrderMap, pL+1,pL+leftIndex, iL, midIndex-1);
        node.right = buildTreeRec(preorder, inOrderMap, pL+leftIndex+1, pR, midIndex+1,iR);

        return  node;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        ConstructTree constructTree = new ConstructTree();
        TreeNode treeNode = constructTree.buildTree(preorder, inorder);

        preorder = new int[]{1,2};
        inorder =  new int[]{2,1};
        treeNode = constructTree.buildTree(preorder, inorder);

        preorder = new int[]{1,2,3};
        inorder =  new int[]{3,2,1};
        treeNode = constructTree.buildTree(preorder, inorder);

        System.out.println("");
    }
}
