package org.cshah.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.List;

public class CheckSumPossible {

    static boolean check_if_sum_possible(long[] arr, long k) {
        return check_if_sum_possible_rec(arr, 0, new ArrayList<Long>(),k);
    }

    static boolean check_if_sum_possible_rec(long[] arr, int movingIndex, List<Long> currentSumList, long k) {

        if (currentSumList.size() != 0 ) {
            long total =0;
            for (long i : currentSumList) {
                total += i;
            }

            if (total == k)
             return true;
        }

        if (movingIndex == arr.length) {
            return false;
        }

       boolean val1 = check_if_sum_possible_rec(arr, movingIndex+1, currentSumList , k);
        if (val1 == true)
            return val1;

        boolean var2 = check_if_sum_possible_rec(arr, movingIndex+1, currentSumList, k);

        return var2;
    }

    public static void main(String arg[]) {
            long[] arr = new long[] {2,10,20};
            System.out.println(CheckSumPossible.check_if_sum_possible(arr,0));

        arr = new long[] {1,2,3};
        System.out.println(CheckSumPossible.check_if_sum_possible(arr,6));

        arr = new long[] {7, -100000000000000l, -100000000000000l,-800000000000000l, -300000000000000l, -1800000000000000l, 1100000000000000l, 600000000000000l};
        System.out.println(CheckSumPossible.check_if_sum_possible(arr,-900000000000000l));

    }
}
