package org.cshah.algorithms.misc;

import java.util.Arrays;

public class ClosestSum {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length ==3) {
            return  nums[0] +nums[1]+ nums[2];
        }
        Arrays.sort(nums);
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i < nums.length; i++) {
            for (int j=i+1; j < nums.length; j++) {
                for (int k=j+1; k < nums.length;k++) {
                    int sum = nums[i] + nums[j] + nums[k];
           //        System.out.println("SUM " + sum);

                    if (sum >= target) {
                        minSum= Math.min(minSum, sum);
                    }

                    if (sum <= target) {
                        maxSum = Math.max(maxSum, sum);
                    }
                }

            }
        }
        if (minSum == Integer.MAX_VALUE)
            return  maxSum;

        if (maxSum == Integer.MIN_VALUE)
            return  minSum;

            if (minSum-target < target-maxSum)
                return minSum;

            return maxSum;
    //    return minSum;
    }

    public static void main(String[] args) {
        ClosestSum closestSum = new ClosestSum();

        int[] data = new int[]{-1, 2, 1, -4};
        int value =closestSum.threeSumClosest(data, 1);
        System.out.println(value);

        data = new int[]{0,1,2};
        value =closestSum.threeSumClosest(data, 3);
        System.out.println(value);

        data = new int[]{0,1,2};
        value =closestSum.threeSumClosest(data, 0);
        System.out.println(value);

        data = new int[]{1,1,1,1};
        value =closestSum.threeSumClosest(data, 0);
        System.out.println(value);

    }
}
