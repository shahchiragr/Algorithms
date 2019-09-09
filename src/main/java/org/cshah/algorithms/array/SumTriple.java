package org.cshah.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumTriple {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for (int i=0; i < nums.length-2; i++) {
            int start= i+1;
            int end = nums.length-1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    List<Integer> integerList = new ArrayList<Integer>();
                    integerList.add(nums[i]);
                    integerList.add(nums[start]);
                    integerList.add(nums[end]);
                    if (!result.contains(integerList))
                        result.add(integerList);
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }// while
        }//for

        return  result;
    }

    public static void main(String[] args) {
        int[] data = new int[] {-1, 0, 1, 2, -1, -4};
        SumTriple sumTripple = new SumTriple();
        List<List<Integer>> result =  sumTripple.threeSum(data);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println("");
        }
    }
}
