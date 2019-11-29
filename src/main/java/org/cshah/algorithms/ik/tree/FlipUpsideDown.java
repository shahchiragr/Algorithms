package org.cshah.algorithms.ik.tree;

public class FlipUpsideDown {

    static TreeNode flipUpsideDown(TreeNode root){
        if (root == null)
            return  root;

        if (root.left_ptr == null && root.right_ptr == null)
            return  root;

        TreeNode newRoot = flipUpsideDown(root.left_ptr);

        root.left_ptr.left_ptr = root.right_ptr;
        root.left_ptr.right_ptr = root;

        root.left_ptr = null;
        root.right_ptr = null;

        return  newRoot;
    }



        public static TreeNode generateTree() {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode t2 = new TreeNode();
        t2.val =2;
        TreeNode t3 = new TreeNode();
        t3.val =3;

        TreeNode t4 = new TreeNode();
        t4.val =4;
        TreeNode t5 = new TreeNode();
        t5.val =5;

        t2.left_ptr= t4;
        t2.right_ptr = t5;


        root.left_ptr = t2;
        root.right_ptr = t3;

        return root;
    }

    public static void main(String[] args) {
        TreeNode newNode = FlipUpsideDown.flipUpsideDown(generateTree());
        System.out.println("");
    }
}
