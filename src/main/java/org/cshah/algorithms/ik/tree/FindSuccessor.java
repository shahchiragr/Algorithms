package org.cshah.algorithms.ik.tree;

import org.cshah.algorithms.tree.TreeNode;

public class FindSuccessor {


    public static TreeNode generateTree() {
        TreeNode root = new TreeNode(44);
        TreeNode t17 = new TreeNode(17);
        TreeNode t88 = new TreeNode(88);
        root.left = t17;
        root.right = t88;

        TreeNode t8 = new TreeNode(8);
        TreeNode t32 = new TreeNode(32);
        TreeNode t28 = new TreeNode(28);
        TreeNode t29 = new TreeNode(29);

        t17.left = t8;
        t17.right = t32;

        t32.left = t28;
        t28.right = t29;

        TreeNode t65 = new TreeNode(65);
        TreeNode t97 = new TreeNode(97);

        t88.left = t65;
        t88.right = t97;

        TreeNode t54 = new TreeNode(54);
        TreeNode t82 = new TreeNode(82);

        t65.left = t54;
        t65.right = t82;

        TreeNode t76 = new TreeNode(76);

        t82.left = t76;
        TreeNode t80 = new TreeNode(80);

        t76.right = t80;

        TreeNode t93 = new TreeNode(93);

        t97.left = t93;

        return root;
    }

    public static TreeNode getSuccessorNode(TreeNode root, TreeNode p) {
        if (root == null ||  p == null) {
            return null;
        }

        TreeNode curr = null;
        if (p.right != null) {
            curr = p.right;
            while (curr.left != null)
                curr = curr.left;

            return curr;
        }

        //search from root to find the p
        TreeNode ancestor = null;
        curr = root;
        while (curr.val != p.val) {
            if (p.val < curr.val) {
                ancestor = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return ancestor;
    }

    public static TreeNode insertNode(TreeNode root, int key) {
        TreeNode newNode = new TreeNode(key);
        if (root == null) {
            return newNode;
        }

        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null) {
            if (curr.val == key) {
                System.out.println("Key already exists... " + key);
                return root;
            }

            if (key < curr.val) {
                prev = curr;
                curr = curr.left;
            } else {
                prev = curr;
                curr = curr.right;
            }

            if (key < prev.val) {
                prev.left = newNode;
            } else {
                prev.right = newNode;
            }
        }
        return  root;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root== null)
            return  null;

        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null) {
            if (curr.val == key) {
                break;
            } else if (key < curr.val) {
                prev = curr;
                curr = curr.left;
            } else {
                prev = curr;
                curr = curr.right;
            }
        }

        if (curr == null)
            return  root;

        if (prev == null) {
            // there is only one node in the tree
            return null;
        }

        //current node is leaf
        if (curr.left == null && curr.right == null) {
            if (prev.left.val == key) {
                curr.left = null;
            } else {
                curr.right = null;
            }
        } else if ( curr.left == null || curr.right == null){
            //current node has only one child
            TreeNode child = null;
            if (curr.left == null && curr.right != null) {
                child = curr.right;
            } else if (curr.left != null && curr.right == null) {
                child = curr.left;
            }

            if (child != null) {
                if (prev == null) {
                    root = child;
                    return root;
                }

                if (curr.val == prev.left.val) {
                    prev.left = child;
                } else {
                    prev.right = child;
                }
            }
        } else if (curr.left != null && curr.right != null) {
            TreeNode succ = curr.right;
            prev = curr;
            while (succ.left != null) {
                prev = succ;
                succ = succ.left;
            }

            curr.val = succ.val;
            if (succ == prev.left) {
                prev.left = succ.right;
            } else {
                prev.right = succ.right;
            }
        }

        return root;
    }
    public static TreeNode getNode(TreeNode root, int value) {
        if (root == null)
            return  null;

        if (root.val == value)
            return root;

        if (value < root.val)
            return getNode(root.left, value);

        if (value > root.val)
            return getNode(root.right, value);

        return null;
    }
    public static void main(String[] args) {
        TreeNode root = generateTree();
        TreeNode node = FindSuccessor.getSuccessorNode(root, getNode(root, 44) );
        System.out.println("Data " + node.val);

        node = FindSuccessor.getSuccessorNode(root, getNode(root, 32) );
        System.out.println("Data " + node.val);

    }
}
