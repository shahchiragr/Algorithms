package org.cshah.algorithms.leetcode.easy;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums.length ==0)
            return 0;

        int sum = nums[0];
        int currentSum =0;

        for (int index=0; index < nums.length;index++) {
             currentSum += nums[index];
             sum = Math.max(sum, currentSum);
            if (currentSum < 0  ) {
                currentSum=0;
            }
        }
        return  sum;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {-2,1,-3,4,-1,2,1,-5,4};

        // arr = new int[] {-3,-2,0,-1};
       // arr = new int[] {-1,-2,-3,1};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(arr));
    }
}
