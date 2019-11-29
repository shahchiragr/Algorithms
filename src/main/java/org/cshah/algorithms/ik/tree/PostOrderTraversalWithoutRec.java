package org.cshah.algorithms.ik.tree;

import java.util.Stack;

public class PostOrderTraversalWithoutRec {
    /**
     * This is pre order traversal without recursion
     * @param root
     * @return
     */
    static int[] postorderTraversal(TreeNode root){
        Stack<Integer> resultStack = new Stack<Integer>();

        if (root ==null)
            return new int[0];

        Stack <TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            resultStack.push(node.val);

            if (node.left_ptr != null)
                nodeStack.push(node.left_ptr);

            if (node.right_ptr != null)
                nodeStack.push(node.right_ptr);

        }

        int[] arr = new int[resultStack.size()];
        int index =0;

        while (!resultStack.isEmpty()) {
            arr[index++] = resultStack.pop().intValue();
        }

        return  arr;
    }

}
