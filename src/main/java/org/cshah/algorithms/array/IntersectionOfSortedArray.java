package org.cshah.algorithms.array;

import java.util.*;

public class IntersectionOfSortedArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        int[] larger = nums1.length > nums2.length ? nums1 : nums2;
        int[] smaller = nums1.length <= nums2.length ? nums1 : nums2;

        /**
         * Sort larger array because now we can run in m * log(n) time complexity
         * where m is smaller array and n is larger array
         * e.g. if smaller array is 16 and larger is 64 than -> 16 * 6 => 96
         * and if we run other way then 64 * 4 => 256. so always try to sort larger array and perform binary search on that array to optimize
         */
        Arrays.sort(larger);
        for (int i=0; i < smaller.length;i++) {
            if (binarySearch(larger, smaller[i])) {
                set.add(smaller[i]);
            }
        }
        int[] result = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            result[index++] = iterator.next();
        }

        return result;
    }

    public boolean binarySearch(int arr[], int elem) {
            int start = 0;
            int end = arr.length;

            while (start < end) {
                int mid = start + ((end-start)/2);
                if ( arr[mid] == elem)
                return true;

                if (elem < arr[mid]) {
                    end = mid;
                }

                if (elem > arr[mid]) {
                    start=mid+1;
                }
            }

            return false;
    }
    public static void main(String[] args) {
        int[] num1 = new int[] {4,9,5};
        int[] num2 = new int[] {9,4,9,8,4};

        IntersectionOfSortedArray intersectionOfSortedArray = new IntersectionOfSortedArray();
        int[] result = intersectionOfSortedArray.intersection(num1, num2);

        for (int i : result) {
            System.out.println(i);
        }

         num1 = new int[] {3,1,2};
         num2 = new int[] {1,3};
         result = intersectionOfSortedArray.intersection(num1, num2);

        for (int i : result) {
            System.out.println(i);
        }

        num1 = new int[] {1};
        num2 = new int[] {1};
        result = intersectionOfSortedArray.intersection(num1, num2);

        for (int i : result) {
            System.out.println(i);
        }

    }
}
