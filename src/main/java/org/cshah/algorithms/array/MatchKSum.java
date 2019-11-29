package org.cshah.algorithms.array;

import java.util.Arrays;

public class MatchKSum {
    public boolean matchKSum(int[] input, int k) {
        int[] sortedArray = Arrays.copyOf(input, input.length);
        Arrays.sort(sortedArray);

        int start = 0;
        int end = sortedArray.length-1;

        while (start < end) {
            int sum = sortedArray[start] + sortedArray[end];
            if (sum == k)
                return true;

            if (sum > k)
                end  --;
            else
                start++;
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
