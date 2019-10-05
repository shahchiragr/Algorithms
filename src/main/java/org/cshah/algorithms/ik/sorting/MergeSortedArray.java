package org.cshah.algorithms.ik.sorting;

public class MergeSortedArray {
    static void merger_first_into_second(int[] arr1, int[] arr2) {
        /*
         * Write your code here.
         */
        int arr1Counter = arr1.length -1;
        int arr2Counter = arr1.length -1;

        int index = arr2.length-1;

        while (arr1Counter >= 0 && arr2Counter >= 0) {
          if (arr1[arr1Counter] > arr2[arr2Counter]) {
              arr2[index] = arr1[arr1Counter--];
          }  else {
              arr2[index] = arr2[arr2Counter--];
          }
          index--;
        }

        while (arr1Counter >= 0) {
            arr2[index] = arr1[arr1Counter--];
            index--;
        }

    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,3,9};
        int[] arr2 = new int[arr1.length*2];
        arr2[0] = 5;
        arr2[1] = 6;
        arr2[2] = 7;
        arr2[3] = 8;

        MergeSortedArray.merger_first_into_second(arr1, arr2);
        for (int i : arr2 ) {
            System.out.print(i + " ");
        }

    }
}
