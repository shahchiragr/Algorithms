package org.cshah.algorithms.leetcode.hard;

public class FindMedianFromTwoSortedArray {

    public double findMedianSortedArrays(int[] array1, int[] array2) {
        if (array1.length > array2.length)
            findMedianSortedArrays(array2, array1);

        int x = array1.length;
        int y = array2.length;

        int low = 0;
        int high = x;

        while (low <= high) {

            int partitionX = (low+ high)/2;
            int partitionY = (x+y+1)/2 - partitionX;

            int maxLeftX = (partitionX == 0)? Integer.MIN_VALUE : array1[partitionX-1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : array1[partitionX];

            int maxLeftY = (partitionY == 0)? Integer.MIN_VALUE : array2[partitionY-1];
            int minRightY = (partitionY ==y) ? Integer.MAX_VALUE : array2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY  <= minRightX) {
                    if ( (x+y)%2 == 0) {
                        return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)/2);
                    } else {
                        return (double)Math.max(maxLeftX, maxLeftY);
                    }
            } else if (maxLeftX > minRightY) {
                high = partitionX-1;
            } else {
                low = partitionX+1;
            }
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int input1[] = {1,3,8,9,15};
        int input2[] = {7,11,18,19,21,25};

        FindMedianFromTwoSortedArray findMedianFromTwoSortedArray = new FindMedianFromTwoSortedArray();
        System.out.println("Median is : " + findMedianFromTwoSortedArray.findMedianSortedArrays(input1, input2));
    }
}
