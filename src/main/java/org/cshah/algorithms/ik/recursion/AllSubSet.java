package org.cshah.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity is O(2 power n * n) because we have to print this list n times
 * and space complexity is the height of the tree which is O(n)
 */
public class AllSubSet {

    public void allSubSetRec(List<Integer> results, List<Integer> items) {
        if (items.size() == 0) {
            for (Integer i : results) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        allSubSetRec(results, items.subList(1, items.size()));

        results.add(items.get(0));
        allSubSetRec(results, items.subList(1, items.size()));
        results.remove(items.get(0));
    }
    public static void main(String[] args) {
        List<Integer> data =new ArrayList<Integer>();
        data.add(1);
        data.add(2);
        data.add(3);

        AllSubSet subSet = new AllSubSet();
        List<Integer> result = new ArrayList<Integer>();
        subSet.allSubSetRec(result, data);
    }
}
