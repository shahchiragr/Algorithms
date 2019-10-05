package org.cshah.algorithms.ik.sorting;

public class MergeSort implements  ISort{

    public  int[] sort(int[] data) {
        return mergeSort(data, 0, data.length);

    }
    public int[] mergeSort(int[] array, int start, int end) {
        if (array.length <= 1)
            return  array;

        int mid =   ((end+start)/2);
        int[] left =new int[mid];
        int[] right = new int[end-mid];

        try {
            System.arraycopy(array, start, left, 0, mid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
          System.arraycopy(array,mid,right,0, end-mid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int[] L = mergeSort(left, 0, left.length);
        int[] R = mergeSort(right, 0 , right.length);

        return merge(L,R);
    }

    public int[] merge(int[] L, int[] R) {
        int[] results = new int[L.length + R.length];
        int left = 0;
        int right =0;
        int index =0;
        while (left < L.length && right < R.length) {
            if (L[left] < R[right]) {
                results[index++] = L[left++];
            } else {
                results[index++] = R[right++];
            }
        }

        while (left < L.length) {
            results[index++] = L[left++];
        }

        while (right < R.length) {
            results[index++] = R[right++];
        }

        return  results;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {3,4,2,7,8,5,1,6,11,12,10,-1,0,43,66,43,22,545,88,99,65};
        MergeSort sort = new MergeSort();
        int r[]= sort.sort(arr);
        for (int i : r) {
            System.out.print(i + " ");
        }
    }
}
