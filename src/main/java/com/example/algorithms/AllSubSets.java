package com.example.algorithms;

import java.util.ArrayList;

/**
 * Created by chirag on 9/10/16.
 */
public class AllSubSets {
    public static ArrayList<ArrayList<Integer>> getSubSet2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>>  allsubSets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << set.size(); // multiply by 2

        for (int i = 0; i < max; i++) {
            ArrayList<Integer> set1 = new ArrayList<Integer>();
            int k =  i;
            int index = 0;

            while (k > 0) {
                if ( ( k & 1) > 0) {
                    set1.add(set.get(index));
                }
                k >>= 1;
                index++;
            }

            allsubSets.add(set1);
        }

        return allsubSets;
    }

    public static void main(String args[]) {
        ArrayList<Integer>  list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        ArrayList<ArrayList<Integer>>  allSubSets = AllSubSets.getSubSet2(list);

        for (ArrayList<Integer> integerArrayList : allSubSets) {
            print(integerArrayList);
        }
    }

    public static void print(ArrayList<Integer> list) {
        for (Integer ii : list) {
            System.out.print(ii + " " );
        }

        System.out.println();
    }
}
