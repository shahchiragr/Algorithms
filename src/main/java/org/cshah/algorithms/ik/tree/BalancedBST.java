package org.cshah.algorithms.ik.tree;

public class BalancedBST {

    static TreeNode build_balanced_bst(int[] a) {
        if (a.length ==0)
            return  null;

        TreeNode root = build_balanced_bst(a, 0, a.length-1);
        return root;
    }

    static TreeNode build_balanced_bst(int[] a, int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode();
        root.val = a[mid];
        root.left_ptr = build_balanced_bst(a, start, mid-1);
        root.right_ptr = build_balanced_bst(a, mid+1, end);

        return  root;
    }


    public static void main(String[] args) {
        int a[] = new int[] {1,2,3,4,5,6,7,8,9,10};
        TreeNode root = BalancedBST.build_balanced_bst(a);
    }
}
