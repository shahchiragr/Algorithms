package org.cshah.algorithms.array;

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

    public static void main(String args[]) {
        TwoSum twoSum = new TwoSum();
        int[] data = new int[] {2,7,11,15};
        int[] answer = twoSum.twoSum(data, 9);

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
