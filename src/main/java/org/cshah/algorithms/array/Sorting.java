package org.cshah.algorithms.array;

/**
 * Created by chirag on 9/11/16.
 */
public class Sorting {
    int N;


    /***************** HEAP SORT Time complexity n(long n) *******************/
    public void heapSort(int[] array) {
        N = array.length-1;
        heapify(array);
//        System.out.println("After heapfy");
//        print(array);
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
        int left = 2*i; // Left ListNode
        int right = 2*i+1; // Right ListNode

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

    /***************** QUICK SORT Time complexity n(long n) *******************/

    public void quickSort(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        quickSort(inputArr, 0, inputArr.length - 1);
    }

     private void quickSort(int[] array, int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
                        /**
                          * In each iteration, we will identify a number from left side which
                          * is greater then the pivot value, and also we will identify a number
                          * from right side which is less then the pivot value. Once the search
                          * is done, then we exchange both numbers.
                          */

            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                 int temp = array[i];
                 array[i] = array[j];
                 array[j] = temp;
                //move index to next position on both sides
                i++;
                j--;
            } //if
        } //while

        // call quickSort() method recursively
        if (lowerIndex < j) {
            quickSort(array, lowerIndex, j);
        }

        if (i < higherIndex) {
            quickSort(array, i, higherIndex);
        }
    }

    /***************** MERGE SORT Time complexity n(log n) *******************/

    private void mergeSort(int array[],int tempMergArr[], int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            mergeSort(array,tempMergArr,lowerIndex, middle);
            // Below step sorts the right side of the array
            mergeSort(array,tempMergArr, middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(array, tempMergArr,lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int array[], int tempMergArr[], int lowerIndex, int middle, int higherIndex) {

//        System.arraycopy(array,lowerIndex, tempMergArr,lowerIndex, higherIndex-lowerIndex+1);
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }

        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        while (i <= middle && j <= higherIndex) {

            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }

            k++;
        }

        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }

    /***************************************** Insertion Sort ***********************************************/
    public int[] insertionSort(int arr[]) {
        for (int i=arr.length-1; i>=0; i--) {
            int temp = arr[i];
            int j=0;

            for (j = i-1; j >=0 && temp < arr[j]; j--) {
                arr[j+1] = arr[j];
                print(arr);

            }
            arr[j+1] = temp;
        }
        print(arr);

        return arr;
    }

//- See more at: http://www.java2novice.com/java-sorting-algorithms/merge-sort/#sthash.a5nkkql3.dpuf
    public static void main(String args[]) {
        int array1[] = new int[] {5,2,9,3,1,15,8};
        int array[] = new int[] {98,90,77,65,10,2,4,7};
        Sorting sorting = new Sorting();
 //       sorting.heapSort(array);

  //      sorting.quickSort(array);

//        sorting.mergeSort(array, new int[array.length], 0, array.length-1);
//        System.out.println("Answer is ....");
//        sorting.print(array);
//
        sorting.insertionSort(new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1});
    }
}
