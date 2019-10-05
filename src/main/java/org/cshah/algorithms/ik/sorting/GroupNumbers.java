package org.cshah.algorithms.ik.sorting;

public class GroupNumbers {
    static int[] solve(int[] arr) {
        int start = 0;
        int end = arr.length -1;

        while (start < end) {
            if (arr[start]%2 ==1 && arr[end]%2 ==0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            } else if ( arr[start]%2 == 0) {
                start++;
            } else if (arr[end]%2 == 1) {
                end --;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6};
         arr = new int[] {2,1,3,4,5,6};
        arr = GroupNumbers.solve(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
