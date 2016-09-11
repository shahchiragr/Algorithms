package com.example.algorithms.array;

/**
 * Created by chirag on 9/11/16.
 */
public class KLargestElement {


    public static int findKLargest(int[] ar, int low, int high, int k) {

        int pivotIndex = partition(ar, low, high);

        if (pivotIndex == k) {
            return ar[pivotIndex];
        } else if (pivotIndex > k) {
            return findKLargest(ar, low, pivotIndex - 1, k);
        } else {
            return findKLargest(ar, pivotIndex + 1, high, k);
        }
    }

    private static int partition(int[] ar, int low, int high) {
        int pivot = ar[low]; //first element as pivot

        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            if (ar[j] < pivot) {
                swap(ar, i, j);
                i++;
            }
        }

        swap(ar, low, i - 1);

        return i - 1;
    }

    private static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args) {
        int ar[] = {3, 1, 2, 1, 4};
        int k = 3; //K is from [1...n]
        int kLargest = findKLargest(ar, 0, ar.length - 1, k - 1);
        System.out.println(kLargest);
    }

}