package org.cshah.algorithms.ik.tree;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBST {
    static class Node {
        int key;
        Node left;
        Node right;

        Node(int k) {
            key = k;
            left = null;
            right = null;
        }
    };

    public static void inOrder(Node root, List<Integer> integerList) {
        if (root == null)
            return;

        inOrder(root.left, integerList);
        integerList.add(root.key);
        inOrder(root.right,integerList);
    }

    public static Node mergeTwoBSTs(Node root1, Node root2) {
        // Write your code here
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        inOrder(root1, list1);
        inOrder(root2, list2);

        Integer[] arr1 = new Integer[list1.size()];
        Integer[] arr2 = new Integer[list2.size()];

        arr1 = list1.toArray(arr1);
        arr2 = list2.toArray(arr2);

        Integer[] sortedArray = mergeSort(arr1,arr2);

        return generateBST(sortedArray, 0, sortedArray.length-1);
    }

    public static Node generateBST(Integer[] array, int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end-start)/2;

        Node root = new Node(array[mid]);
        root.left = generateBST(array, start, mid-1);
        root.right = generateBST(array, mid+1, end);

        return root;
    }

    public static Integer[] mergeSort(Integer[] arr1, Integer[] arr2) {
        if (arr1.length ==0 )
            return arr2;

        if (arr2.length == 0)
            return  arr1;

        int index1 = 0;
        int index2 = 0;
        int counter = 0;
        Integer[] result = new Integer[arr1.length + arr2.length];

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                result[counter++] = arr1[index1++];
            } else if (arr1[index1] > arr2[index2] ) {
                result[counter++] = arr2[index2++];
            } else {
                result[counter++] = arr1[index1++];
            }
        }

        while (index1 < arr1.length) {
            result[counter++] = arr1[index1++];
        }

        while (index2 < arr2.length) {
            result[counter++] = arr2[index2++];
        }

        return result;
    }
    public static void main(String[] args) {
        Node root1 = new Node(7);
        root1.left = new Node(5);
        root1.right= new Node(20);

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right= new Node(15);

        Node root3 = MergeTwoBST.mergeTwoBSTs(root1,root2);

    }
}
