package org.cshah.algorithms.tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Codec {
    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {

        if (root == null)
            return  "";

        StringBuffer stringBuffer = new StringBuffer();
        Queue<TreeNode> nodeQueue = new LinkedBlockingQueue<TreeNode>();
        nodeQueue.offer(root);
        TreeNode nullNode = new TreeNode(Integer.MIN_VALUE);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            if (node != null && !node.equals(nullNode)) {
                stringBuffer.append(node.val + ",");


                if (node.left != null || node.right != null) {
                    if (node.left != null) {
                        nodeQueue.offer(node.left);
                    } else {
                        nodeQueue.offer(nullNode);
                        //stringBuffer.append("null,");
                    }

                    if (node.right != null) {
                        nodeQueue.offer(node.right);
                    } else {
                        nodeQueue.offer(nullNode);
                        // stringBuffer.append("null,");
                    }
                }
            } else if (node.equals(nullNode)){
                stringBuffer.append("null,");
            }
        }

        stringBuffer.setLength(stringBuffer.length()-1);
        return  stringBuffer.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //1,2,3,null,null,4,5
        // 0   1     2   3    4    5    6    7
        // 1,  2,  null, 3, null,  4,  null, 5

        if (data == null || data.length() ==0)
            return  null;

        StringTokenizer st = new StringTokenizer(data, ",");
        String[] nodes = new String[st.countTokens()];
        int index =0;
        while (st.hasMoreTokens()) {
            nodes[index++] = st.nextToken();
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> nodeQueue = new LinkedBlockingQueue<TreeNode>();
        Queue<Integer> indexQueue = new LinkedBlockingQueue<Integer>();
        int currentIndex = 0;

        indexQueue.offer(currentIndex);
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {

            TreeNode node = nodeQueue.poll();
            int nodeIndex = indexQueue.poll();
            int leftChild = 2 * nodeIndex + 1;
            int rightChild = 2 * nodeIndex + 2;
            TreeNode leftNode = generateNode(leftChild, nodes);
            if (leftNode != null) {
                node.left = leftNode;
                nodeQueue.offer(leftNode);
                indexQueue.offer(++currentIndex);
            }

            TreeNode rightNode = generateNode(rightChild, nodes);
            if (rightNode != null) {
                node.right = rightNode;
                nodeQueue.offer(rightNode);
                indexQueue.offer(++currentIndex);
            }
        }

        return root;

    }

    public TreeNode generateNode(int index, String[] nodes) {
        if (index >= nodes.length)
            return  null;

        String data = nodes[index];

        if (data == null || data.length() ==0 || data.equals("null"))
            return  null;

        int value = Integer.parseInt(data);
        TreeNode node = new TreeNode(value);
        return node;
    }


    public TreeNode generateNode() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));

        TreeNode right = new TreeNode(3);
        right.setLeft(new TreeNode(4));
        right.setRight(new TreeNode(5));

        root.setRight(right);
        return  root;
    }
    public static void main(String args[]) {
        Codec codec = new Codec();

        String str =  "1,2,3,null,null,4,5";

        str = "1,2,null,3,null,4,null,5";
        TreeNode root = codec.deserialize(str);
        String result = codec.serialize(root);
        System.out.println(result);

        str = "1,2,3,4,5,6,7,8";
        root = codec.deserialize(str);

        result = codec.serialize(root);
        System.out.println(result);
    }
}
