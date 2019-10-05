package org.cshah.algorithms.array;

import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i=0; i< nums.length; i++) {
            for (int j=i+1; j < nums.length;j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        return answer;
    }

    public boolean twoSums(int[] nums, int target) {
        Arrays.sort(nums);
        int start=0;
        int end = nums.length-1;

        while (start < end ) {
            int sum = nums[start] + nums[end];
            if (sum == target)
                return  true;

            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        TwoSum twoSum = new TwoSum();
        int[] data = new int[] {2,7,11,15};
        int[] answer = twoSum.twoSum(data, 9);

        System.out.println(twoSum.twoSums(data, 9));

        System.out.println(twoSum.twoSums(data, 19));

        for (int i : answer) {
            System.out.println(i);
        }

         data = new int[] {3,2,4};
         answer = twoSum.twoSum(data, 6);

        for (int i : answer) {
            System.out.println(i);
        }

    }
}
