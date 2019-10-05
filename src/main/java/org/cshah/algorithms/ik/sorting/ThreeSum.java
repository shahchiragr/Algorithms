package org.cshah.algorithms.ik.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ThreeSum {

    static String[] findZeroSum(int[] arr) {
        Arrays.sort(arr);
        Set<String> stringSet = new HashSet<String>();
        for (int i=0; i < arr.length;i++) {
            int sum = arr[i];
            int start = i+1;
            int end = arr.length-1;
            while (start < end) {

                int anotherSum = arr[start] + arr[end];

                if (sum + anotherSum == 0) {
                    String str = arr[i] + "," + arr[start] + "," + arr[end];
                    stringSet.add(str);
                }//if

                if (sum + anotherSum > 0) {
                    end --;
                } else {
                    start++;
                }
            }
        }

        String[] results = new String[stringSet.size()];
        Iterator<String> iterator = stringSet.iterator() ;
        int counter = 0;
        while (iterator.hasNext()) {
            results[counter++] = iterator.next();
        }


        return results;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {-2, 2, 0, -2, 2};
        arr = new int[] {10, 3, -4, 1, -6, 9};

   //     arr = new int[] {0,0,0};
        String[] result = ThreeSum.findZeroSum(arr);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
