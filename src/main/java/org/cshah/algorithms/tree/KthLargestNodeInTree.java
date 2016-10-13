package org.cshah.algorithms.tree;

/**
 * Created by cshah on 5/8/14.
 */
public class KthLargestNodeInTree {
    int count=0;

    Tree Largest(Tree root, int k) {
        if (root == null)
            return  null;
        Tree right = Largest(root.getRight(), k);
        if (right !=  null)
            return  right;
        count++;
        if (count == k)
            return root;

        return Largest(root.getLeft(), k);
    }

    public static void main(String args[]) {
        Tree leftNode = new Tree(50, new Tree(25,null,null), new Tree(75,null,null));
        Tree rightNode = new Tree(150, new Tree(125,null,null), new Tree(175,null,null));
        Tree root = new Tree(100, leftNode, rightNode);

        KthLargestNodeInTree obj = new KthLargestNodeInTree();
        Tree tree = obj.Largest(root,3);
        System.out.println("Tree " + tree.getValue());


    }

}
