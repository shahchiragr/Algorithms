package org.cshah.algorithms.ik.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestElement {

    static int kth_smallest_element(TreeNode root, int k) {
        return  kth_smallest_element(root, new AtomicInteger(0), k);
    }

    static int kth_smallest_element(TreeNode root, AtomicInteger counter, int k) {
        if (root == null)
            return  Integer.MIN_VALUE;

        int val = kth_smallest_element(root.left_ptr,counter,k );

        if (val != Integer.MIN_VALUE)
            return val;

        counter.incrementAndGet();

        if (counter.get() == k)
            return root.val;

        val = kth_smallest_element(root.right_ptr,counter,k);
        if (val != Integer.MIN_VALUE)
            return val;

        return val;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val = 10;

        TreeNode n8 = new TreeNode();
        n8.val = 8;

        TreeNode n12 = new TreeNode();
        n12.val = 12;

        node.left_ptr = n8;
        node.right_ptr = n12;

        TreeNode n7 = new TreeNode();
        n7.val = 7;

        TreeNode n9 = new TreeNode();
        n9.val = 9;

        n8.left_ptr = n7;
        n8.right_ptr = n9;

        TreeNode n11 = new TreeNode();
        n11.val = 11;

        TreeNode n13 = new TreeNode();
        n13.val = 13;

        n12.left_ptr = n11;
        n12.right_ptr = n13;

        int item = KthSmallestElement.kth_smallest_element(node, 1);
        System.out.println(item);

        item = KthSmallestElement.kth_smallest_element(node, 2);
        System.out.println(item);
        item = KthSmallestElement.kth_smallest_element(node, 3);
        System.out.println(item);

        item = KthSmallestElement.kth_smallest_element(node, 4);
        System.out.println(item);

        item = KthSmallestElement.kth_smallest_element(node, 5);
        System.out.println(item);

    }
}
