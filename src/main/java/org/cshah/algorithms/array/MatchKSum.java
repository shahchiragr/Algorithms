package org.cshah.algorithms.array;

import java.util.Arrays;

public class MatchKSum {
    public boolean matchKSum(int[] input, int k) {
        int[] sortedArray = Arrays.copyOf(input, input.length);
        Arrays.sort(sortedArray);
        for (int i= sortedArray.length-1; i >=0; i--) {
            for (int j=0; j < sortedArray.length; j++) {
                int sum = sortedArray[i] + sortedArray[j];
                if ( sum == k) {
                    return  true;
                }

                if (sum > k)
                    i --;
                else j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[] {10,15,3,7};
        int k = 17;

        MatchKSum matchKSum = new MatchKSum();
        System.out.println(matchKSum.matchKSum(array, 17));
        System.out.println(matchKSum.matchKSum(array, 31));
        System.out.println(matchKSum.matchKSum(array, 12));

    }
}
