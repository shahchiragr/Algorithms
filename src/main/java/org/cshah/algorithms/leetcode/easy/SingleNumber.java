package org.cshah.algorithms.leetcode.easy;

/**
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int i=0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int arr[] = new int[] {4,1,2,1,2};

        // arr = new int[] {-3,-2,0,-1};
        // arr = new int[] {-1,-2,-3,1};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(arr));
    }
}
