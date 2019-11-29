package org.cshah.algorithms.ik.tree;

public class BTreeToLL {

    static TreeNode head=null;
    static TreeNode prev=null;

    static TreeNode BTtoLL(TreeNode root) {
            convertTreeToDLL(root);

            if (head != null)
                head.left_ptr =  prev;

            if (prev != null)
                 prev.right_ptr= head;
            return head;
    }

    static void convertTreeToDLL(TreeNode curr) {
        if (curr == null)
            return;

        convertTreeToDLL(curr.left_ptr);

        if (head == null) {
            head= curr;
        } else {
             prev.right_ptr = curr;
             curr.left_ptr = prev;
        }

        prev = curr;

        convertTreeToDLL(curr.right_ptr);
    }
    /*
    static TreeNode BTtoLL(TreeNode root){
        if (root == null)
            return  root;

        TreeNode leftHead = BTtoLL(root.left_ptr);
        TreeNode rightHead = BTtoLL(root.right_ptr);

        root.left_ptr = root.right_ptr = root;

        TreeNode currentCLL = connectTwoCLL(leftHead, root);
        currentCLL = connectTwoCLL(currentCLL, rightHead);

        return  currentCLL;

    }

    public static TreeNode connectTwoCLL(TreeNode leftHead, TreeNode rightHead) {
        if (leftHead == null)
            return  rightHead;

        if (rightHead == null)
            return  leftHead;

        TreeNode leftTail = leftHead.left_ptr;
        TreeNode rightTail = rightHead.left_ptr;

        leftTail.right_ptr = rightHead;
        rightHead.left_ptr = leftTail;

        rightTail.right_ptr = leftHead;
        leftHead.left_ptr = rightTail;

        return  leftHead;
    }

    */

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

//        n20.left_ptr = n40;
 //       n20.right_ptr = n50;

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = constructTree();
        TreeNode newNode = BTreeToLL.BTtoLL(root);
        System.out.println("here");

    }
}
