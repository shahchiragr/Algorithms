package org.cshah.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class NArrayPreOrderTraversal {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if ( node.children!= null && !node.children.isEmpty()) {
                int count =node.children.size()-1;
                while (count >= 0) {
                    stack.push(node.children.get(count));
                    count--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Node n5 = new Node(5, null);
        Node n6 = new Node(6, null);
        List<Node> list = new ArrayList<Node>();
        list.add(n5);
        list.add(n6);
        Node n3 = new Node(3, list);
        Node n2 = new Node(2, null);
        Node n4 = new Node(4, null);
        List<Node> list1 = new ArrayList<Node>();
        list1.add(n3);
        list1.add(n2);
        list1.add(n4);

        Node n = new Node(1, list1);

        NArrayPreOrderTraversal nArrayPreOrderTraversal = new NArrayPreOrderTraversal();
        List<Integer> list2 = nArrayPreOrderTraversal.preorder(n);
        for (Integer o : list2) {
            System.out.println(o);
        }
    }

}
