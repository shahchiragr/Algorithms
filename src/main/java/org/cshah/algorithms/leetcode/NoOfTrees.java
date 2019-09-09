package org.cshah.algorithms.leetcode;

import java.util.*;

/**
 * reference https://www.youtube.com/watch?v=GgP75HAvrlY
 */
public class NoOfTrees {

    public int numTrees(int n) {
        if (n == 0 || n == 1)
            return 1;
        int arry[] = new int[n+1];
        arry[0] = 1;
        arry[1] = 1;

        for (int i=2; i <= n;i++) {
            for (int j=1; j <=i;j++) {
                arry[i] += arry[j - 1] * arry[i - j];
            }
        }

        return arry[n];
    }

    /*
        public int numTrees_old(int n) {
        Map<Integer,Boolean> booleanMap = new HashMap<Integer, Boolean>();

        for (int i=1;i<=n;i++) {
            booleanMap.put(i, false);
        }

        List<Integer> numberList = new ArrayList<Integer>();
        Set<String> uniqueTreeSet = new HashSet<String>();
        buildRec(booleanMap, n, 1,numberList, uniqueTreeSet);
        return  uniqueTreeSet.size();
    }

    public void buildRec(Map<Integer,Boolean> visitedNumber, int length,int level, List<Integer> numberList, Set<String> treeSet ) {

        if (level > length) {
            String uniqueString = generateTree(numberList);
            treeSet.add(uniqueString);
            return;
        }

        for (int i=1; i <=length; i++) {
            if (visitedNumber.get(i) == true)
                continue;
            numberList.add(i);
            visitedNumber.put(i, true);

            buildRec(visitedNumber,length, level+1,numberList,treeSet);
            numberList.remove(numberList.size()-1);
            visitedNumber.put(i, false);

        }
    }

    public String generateTree(List<Integer> list) {
        if (list.isEmpty())
            return null;

        BST root = new BST();
        root.setElement(list.get(0));

        for (int i=1; i < list.size(); i++) {
            BST node =new BST();
            node.setElement(list.get(i));
            insert(root, node);
        }

        StringBuffer sb = new StringBuffer();
        printPostOrder(root,sb);
        return sb.toString();
    }


    private void printPostOrder(BST root,StringBuffer sb) {
        if (root == null)
            return;

        printPostOrder(root.getLeft(),sb);
        printPostOrder(root.getRight(),sb);
        sb.append(root.getElement());

    }

    private void insert(BST root, BST node) {
            if (root == null) {
                root = node;
                return;
            }

            if (root.getElement() > node.getElement()) {
                if (root.getLeft() == null) {
                    root.setLeft(node);
                } else {
                    insert(root.getLeft(), node);
                }
            } else  {
                if (root.getRight() == null) {
                    root.setRight(node);
                } else {
                    insert(root.getRight(), node);
                }
            }
    }

    class BST {
        int element;
        BST left;
        BST right;

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public BST getLeft() {
            return left;
        }

        public void setLeft(BST left) {
            this.left = left;
        }

        public BST getRight() {
            return right;
        }

        public void setRight(BST right) {
            this.right = right;
        }
    }
*/

    public int numTrees_Algo1(int n) {
        int[][] f = new int[n+1][n+1];

        int result =  helper(1, n, f);

        for (int i=0; i< n+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(f[i][j] +  " | ");
            }
            System.out.println("");
        }


        return result;
    }

    public int helper(int start, int end, int[][] cache){
        if (start > end){
            return 0;
        }
        if (start == end){
            cache[start][end] = 1;
            return 1;
        }
        if (cache[start][end] > 0){
            return cache[start][end];
        }
        int n = 0;
        for (int i = start; i <= end; i++){
            int left = helper(start, i-1, cache);
            int right = helper(i+1, end, cache);
            n += (left == 0 ? 1 : left) * (right == 0 ? 1 : right);
        }
        cache[start][end] = n;
        return n;
    }


    public int numTrees_Algo2(int n) {
        int[] memo = new int[n + 1];
        if(n == 0)
            return 1;
        if(n == 1)
            return 1;
        memo[0] = 1;
        memo[1] = 1;

        for(int i = 2; i <= n; i++)
        {
            int count = 0;
            for(int j = 1; j <= i; j++)
            {
                count += memo[j-1] * memo[i-j];
            }
            memo[i] = count;
        }
        return memo[n];
    }

    public static void main(String[] args) {
        NoOfTrees noOfTrees = new NoOfTrees();
        System.out.println(noOfTrees.numTrees(5));
//        System.out.println(noOfTrees.numTrees(3));
//        System.out.println(noOfTrees.numTrees(5));
//        System.out.println(noOfTrees.numTrees(10));
    }

}
