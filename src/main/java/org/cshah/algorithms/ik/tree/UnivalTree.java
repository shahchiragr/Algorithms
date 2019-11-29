package org.cshah.algorithms.ik.tree;

public class UnivalTree {

    private static class Result {
        public boolean isUniVal = false;
    }
    static int findSingleValueTrees(TreeNode root){
       if (root == null)
           return 0;

       return findSingleValueTrees_rec(root, root.val, new Result());

    }

    static int findSingleValueTrees_rec(TreeNode root, int value, Result uniValResult){
        if (root == null) {
            uniValResult.isUniVal = true;
            return 0;
        }

        if (root.left_ptr == null && root.right_ptr == null ) {
            uniValResult.isUniVal = true;
            return 1;
        }

         Result leftFlag = new Result();
         int leftCount = findSingleValueTrees_rec(root.left_ptr, root.val, leftFlag);

         Result rightFlag = new Result();
         int rightCount = findSingleValueTrees_rec(root.right_ptr, root.val, rightFlag);


         if (!leftFlag.isUniVal || !rightFlag.isUniVal) {
             return leftCount + rightCount;
         } else {
             if ( ( root.left_ptr != null && root.left_ptr.val != root.val) ||
                   ( root.right_ptr != null && root.right_ptr.val != root.val) ) {
                 return leftCount + rightCount;
             } else  {
                 uniValResult.isUniVal =true;
                 return 1 + leftCount + rightCount;
             }
         }
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode();
        t1.val = 5;

        TreeNode t2 = new TreeNode();
        t2.val = 5;

        TreeNode t3 = new TreeNode();
        t3.val = 5;

        TreeNode t4 = new TreeNode();
        t4.val = 5;

        TreeNode t5 = new TreeNode();
        t5.val = 5;

        TreeNode t6 = new TreeNode();
        t6.val = 5;

        TreeNode t7 = new TreeNode();
        t7.val = 4;

        t1.left_ptr = t2;
        t1.right_ptr = t3;


        t2.left_ptr = t4;
        t2.right_ptr = t5;

        t3.left_ptr = t6;
        t3.right_ptr = t7;

        System.out.println(UnivalTree.findSingleValueTrees(t1));

        TreeNode tt2 = new TreeNode();
        tt2.val = 2;

        TreeNode tt21 = new TreeNode();
        tt21.val = 1;

        TreeNode tt22 = new TreeNode();
        tt22.val = 1;

        tt2.left_ptr = tt21;
        tt2.right_ptr = tt22;

    //    System.out.println(UnivalTree.findSingleValueTrees(tt2));

    }
}
