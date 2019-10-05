package org.cshah.algorithms.array;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by chirag on 9/11/16.
 */
public class KLargestElement {


//    public static int findKLargest(int[] ar, int low, int high, int k) {
//
//        int pivotIndex = partition(ar, low, high);
//
//        if (pivotIndex == k) {
//            return ar[pivotIndex];
//        } else if (pivotIndex > k) {
//            return findKLargest(ar, low, pivotIndex - 1, k);
//        } else {
//            return findKLargest(ar, pivotIndex + 1, high, k);
//        }
//    }
//
//    private static int partition(int[] ar, int low, int high) {
//        int pivot = ar[low]; //first element as pivot
//
//        int i = low + 1;
//        for (int j = low + 1; j <= high; j++) {
//            if (ar[j] < pivot) {
//                swap(ar, i, j);
//                i++;
//            }
//        }
//
//        swap(ar, low, i - 1);
//
//        return i - 1;
//    }
//
//    private static void swap(int[] ar, int i, int j) {
//        int temp = ar[i];
//        ar[i] = ar[j];
//        ar[j] = temp;
//    }

    private static void kthLargestElem(int[] array, int k) {
        Sorting sorting = new Sorting();
        sorting.heapSort(array);
        int largElem = array[array.length-1];
        int count =1;
        for (int i=array.length-2; i >=0; i--) {
            if (array[i] != largElem) {
                count++;
                largElem = array[i];

                if (k == count) {
                    System.out.println(k + "th largest element is " + largElem );
                    break;
                }
            }
        }

    }

    public static int largestElem(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i=0; i < arr.length; i++) {
           maxHeap.offer(arr[i]);
        }

        int counter = 1;
        while (counter != k) {
            maxHeap.poll();
            counter++;
        }
        return maxHeap.peek();
    }
    public static void main(String[] args) {
        int ar[] = {3, 1, 2, 1, 4,15,9,6,8,15,9};
//        int ar[] = {1,2,3,4,5,6,7,8,9};
        int k = 4; //K is from [1...n]
//        int kLargest = findKLargest(ar, 0, ar.length - 1, k - 1);
//        System.out.println(kLargest);
//
        KLargestElement.kthLargestElem(ar, k);

        System.out.println(KLargestElement.largestElem(ar,k));

        ar = new int[] {3,2,1,5,6,4};
        k =2;
        System.out.println(KLargestElement.largestElem(ar,k));

    }

}