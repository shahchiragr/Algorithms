package com.example.algorithms.array;

/**
 * Created by chirag on 9/11/16.
 */
public class Sorting {
    int N;

    /***************** HEAP SORT Time complexity n(long n) *******************/
    public void heapSort(int[] array) {
        N = array.length-1;
        heapify(array);
        System.out.println("After heapfy");
        print(array);
        for (int i=N; i>0; i--) {
//            System.out.println("Swapping " + array[0] + ":" + array[i]);
            swap(array,0, i);
            N = N-1;
            maxheap(array,0);
        }
    }

    private void heapify(int[] array) {
        for (int i=N/2; i >= 0; i--) {
            maxheap(array, i);
        }
    }

    private void maxheap(int[] array, int i) {
        int left = 2*i; // Left Node
        int right = 2*i+1; // Right Node

        int max = i;
        if (left <= N && array[left] > array[i]) {
            max = left;
        }

        if (right <= N && array[right] > array[max]) {
            max = right;
        }

        if (max != i) {
//            System.out.println("Swapping.. " + array[i] + ":" + array[max] + " for  " + i + " and  " + max);
            swap (array, i, max);
            maxheap(array, max);
        }
    }

    private void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void  print (int[] array) {
        for (int i=0; i < array.length;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    public static void main(String args[]) {
        int array[] = new int[] {5,2,9,3,1,15,8};
        Sorting sorting = new Sorting();
        sorting.heapSort(array);
        System.out.println("Answer is ....");
        sorting.print(array);
    }
}
