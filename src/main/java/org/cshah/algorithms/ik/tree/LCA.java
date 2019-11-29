package org.cshah.algorithms.ik.tree;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class LCA {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    /*** Option 1 ***/

    int lca(Node head, Node a, Node b) {
        if (head == null)
            return 0;

        if (head.data == a.data || head.data == b.data)
            return head.data;

        int left = lca(head.left, a,b);
        int right = lca(head.right, a,b);

        if (left == 0)
            return right;

        if (right == 0)
            return left;

        return head.data;
    }

    /*** Option 2 ***/

    /** Eular method for Range Min Query **/
    /*
    String printArray(int[] arr, int counter) {
        StringBuffer sb = new StringBuffer();

        for (int i=0; i < counter; i++) {
            sb.append(arr[i] + " | ");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    int lca(Node head, Node a, Node b) {
        int count = getNodeCount(head);

        //time 2 for now...
        count = count * 2;

        int euler[] = new int[count];
        int levelArr[] = new int[count];
        int first_occurrence[] = new int[count];

        AtomicInteger counter = new AtomicInteger(0);
        Arrays.fill(first_occurrence, -1);

        dfs(head,1, counter, euler,levelArr, first_occurrence );

//        printArray(euler, count);
//        printArray(levelArr, count);
//        printArray(first_occurrence, count);


        int aData = a.data;
        int bData = b.data;
        int f_O_a = first_occurrence[aData];
        int f_O_b = first_occurrence[bData];

        int min = Math.min(f_O_a, f_O_b);
        int max = Math.max(f_O_a,f_O_b);
        int var = Integer.MAX_VALUE;
        int result = 0;

        for (int i=min; i <max; i++) {
            if (var > levelArr[euler[i]]) {
                result = euler[i];
                var = levelArr[euler[i]];
            }

        }

        return result;
    }

    void dfs(Node head, int level, AtomicInteger counter, int[] euler, int[] levelArr, int[] first_occurrence) {
        if (head == null)
            return;

        int nodeData = head.data;
        levelArr[nodeData] = level;
        euler[counter.get()] = nodeData;

        if (first_occurrence[nodeData] == -1) {
            first_occurrence[nodeData] = counter.get();
            counter.incrementAndGet();
        }

        dfs(head.left, level+1,  counter, euler,levelArr, first_occurrence);

        if (head.left != null) {
            euler[counter.get()] = nodeData;
            counter.incrementAndGet();
        }


        dfs(head.right, level+1, counter, euler, levelArr, first_occurrence);

        if (head.right != null) {
            euler[counter.get()] = nodeData;
            counter.incrementAndGet();
        }

    }

    int getNodeCount(Node head) {
        if (head == null)
            return  0;

        int count =0;
        if (head.left != null) {
            count += getNodeCount(head.left);
        }

        if (head.right != null) {
            count += getNodeCount(head.right);
        }

        return 1 + count;
    }


     */

    /*** Option 3 ***/

    // this solutions works but the time complexity is I guess N power N as for every left and right side we have to search entire tree
    /*
    int lca(Node head, Node a, Node b) {
        if (head == null)
            return -1;

        if (head.data == a.data || head.data == b.data)
            return head.data;


        //if node present on left then move left
        if (nodePresent(head.left,a) && nodePresent(head.left, b))
            return  lca(head.left, a,b);

        //if node present on right then move right
        if (nodePresent(head.right,a) && nodePresent(head.right, b))
            return  lca(head.right, a,b);

        return head.data;
    }

    boolean nodePresent(Node head, Node a) {
        if (head == null)
            return  false;

        if (head.data == a.data)
            return true;

        return nodePresent(head.left, a) || nodePresent(head.right, a);
    }

    */
    static Node constructNode() {
        Node n1 = new Node();
        n1.data =1;

        Node n2 = new Node();
        n2.data = 2;

        Node n3 = new Node();
        n3.data = 3;

        Node n4 = new Node();
        n4.data = 4;

        Node n5 = new Node();
        n5.data = 5;

        Node n6 = new Node();
        n6.data = 6;

        Node n7 = new Node();
        n7.data = 7;

        Node n8 = new Node();
        n8.data = 8;

        Node n9 = new Node();
        n9.data = 9;

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n5.left =n8;
        n5.right = n9;

        return  n1;
    }

    public static void main(String[] args) {
        LCA lca = new LCA();
        Node a = new Node();
        a.data = 2;

        Node b = new Node();
        b.data = 3;

       System.out.println( lca.lca(LCA.constructNode(), a,b));


    }
}
