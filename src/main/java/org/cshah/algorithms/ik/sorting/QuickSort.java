package org.cshah.algorithms.ik.sorting;

import java.util.Random;

/**
 * you can run this algo for Quick Select, e.g. for Kth largest or Kth smallest element in the array with O(n) time complexity
 */
public class QuickSort  implements ISort {
    public int[] sort(int[] data) {
        quickSort(data, 0, data.length);
        return data;
    }
    public void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        //take random pivot index from the array
        int pIndex = start + (end-start)/2;

        //first put pivot element in to first index
        swap(arr, start, pIndex);

        //since now we have first element as pivot, we take it from start
        int pivot = arr[start];

        int orangePointer = start; //smaller pointer, where as green is bigger pointer

        for (int greenPointer = start+1; greenPointer < end; greenPointer++) {
            if (arr[greenPointer] < pivot) {
                orangePointer++;
                swap(arr, orangePointer, greenPointer);
            }
        }

        //once we find the smaller element, we just now replace that element with pivot element, which is in the first place
        swap(arr, start, orangePointer);

//        if (orangePointer == indexToBeFound) {
//            System.out.println("Found... " + arr[orangePointer] + " is the " + (arr.length - indexToBeFound) + " largest element...");
//            return;
//        }

//        if (orangePointer > indexToBeFound)
            quickSort(arr, start, orangePointer);

//        if (orangePointer < indexToBeFound)
            quickSort(arr, orangePointer+1, end);

    }

    public void swap(int[] arr, int index1, int index2) {
        int val = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = val;
    }

    public static void main(String[] args) {

        //-1 0 1 2 3 4 5 6 7 8 10 11 12 22 43 44 65 66 88 99 545
        int arr[] = new int[] {3,4,2,7,8,5,1,6,11,12,10,-1,0,43,66,44,22,545,88,99,65};
        // arr = new int[] {3,4,2,7,8,5,1,6};
        QuickSort quickSort = new QuickSort();
        int kthLargest = 3;
        quickSort.sort(arr);

    }
}
