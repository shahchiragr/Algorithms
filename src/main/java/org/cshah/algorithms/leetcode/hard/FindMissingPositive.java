package org.cshah.algorithms.leetcode.hard;

import java.util.Arrays;

public class FindMissingPositive {

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int missingNumber = 1;
        for (int index=0; index < nums.length; index++) {
            if (nums[index] == missingNumber)
                missingNumber++;
        }

        return  missingNumber;
    }

    public static void main(String args[]) {
        FindMissingPositive findMissingPositive = new  FindMissingPositive();

        int[] input1 =  {1,2,0};
        System.out.println(findMissingPositive.firstMissingPositive(input1));

        int[] input2 = {3,4, -1,1};
        System.out.println(findMissingPositive.firstMissingPositive(input2));

        int[] input3 = {7,9,8,11,12};
        System.out.println(findMissingPositive.firstMissingPositive(input3));

    }
}
