package org.cshah.algorithms.educative;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int product = 1, left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left < arr.length) {
                product /= arr[left++];
            }
            // since the product of all numbers from left to right is less than the target
            // therefore, all subarrays from lef to right will have a product less than the target too
            // to avoid duplicates, we will start with a subarray containing arr[right] only and extend it
            List<Integer> tempList = new LinkedList<Integer>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<Integer>(tempList));
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
//        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 200, 5, 3, 10 }, 50));

    }
}
