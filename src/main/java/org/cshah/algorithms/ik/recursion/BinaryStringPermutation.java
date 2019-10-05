package org.cshah.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity is O(2 power n)
 * however this is DFS as left part will be completed first and then it will call right part
 * DFS need only space of height where as BFS need to store O(2 power n) in space
 * so Space complexity is O(n)
 */
public class BinaryStringPermutation {

    /************************************ BFS ************************************/

    /**
     * Space and Time complexity is O(2 power n) because all work has to be done by manager, means at upper level
     * @param n
     */
    public void stringPermutationBFS(int n) {
        List<String> list = stringPermutationBFSRec(n);
        for (String s: list) {
            System.out.println(s);
        }
    }

    public List<String> stringPermutationBFSRec(int n) {
            if (n == 1) {
                List<String> result = new ArrayList<String>();
                result.add("0");
                result.add("1");
                return result;
            }

            List<String> prevResult = stringPermutationBFSRec(n-1);
            List<String> newResult = new ArrayList<String>();
            for (int i=0; i< prevResult.size(); i++) {
                newResult.add(prevResult.get(i) + "0");
                newResult.add(prevResult.get(i) + "1");
            }

            return newResult;
    }

    /************************************ BFS Iterative ************************************/

    public void stringPermutationBFSIterative(int n) {
        List<String> result = new ArrayList<String>();
        result.add("0");
        result.add("1");

        for (int i=2; i <= n; i++) {
           List<String> newList = new ArrayList<String>();

           for (int k=0; k < result.size();k++) {
               newList.add(result.get(k) + "0");
               newList.add(result.get(k) + "1");
           }

           result = newList;
         }

        for (String s: result) {
            System.out.println(s);
        }
    }


    /************************************ DFS ************************************/

 public void stringPermutationDFS(int n, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        stringPermutationDFS(n-1,  str + "0");
        stringPermutationDFS(n-1,  str + "1");

    }
    public static void main(String[] args) {
        BinaryStringPermutation binaryStringPermutation = new BinaryStringPermutation();
  //      binaryStringPermutation.stringPermutationDFS(4,"");
//        binaryStringPermutation.stringPermutationBFS(4);
        binaryStringPermutation.stringPermutationBFSIterative(4);
    }
}
