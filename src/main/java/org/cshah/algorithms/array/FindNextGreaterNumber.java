package org.cshah.algorithms.array;

import java.util.Stack;

public class FindNextGreaterNumber {

    /**
     * This is O(n) algorithm
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i= nums.length-1; i >= 0; i--) {
           int current = nums[i];

           /* if stack is not empty, then
            pop an element from stack.
            If the popped element is smaller
            than next, then
            a) print the pair
            b) keep popping while elements are
            smaller and stack is not empty */

            while (!stack.isEmpty() && stack.peek() <= current)  {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? current : stack.peek();


            stack.push(current);
        }

        return res;
    }


    /**
     * This is O(n2) algorithm eventhough we have it recursive
     * @param array
     * @return
     */
    public static  int[] nextGreaterElementsRecursive(int[] array) {
        int[] result = new int[array.length];

        for (int i=0; i < array.length; i++) {
            result[i] = findMax(array[i], i+1, array);
        }

        return result;
    }

    public static int findMax(int number, int index, int[]array) {
        if (index >= array.length)
            return number;

        int returnNumber =0;
        if (Math.max(number, array[index]) != number) {
            returnNumber=  array[index];
        } else {
            returnNumber = findMax(number ,index+1, array);
        }

        return  returnNumber;
    }

    public static void main(String args[]) {
        int[] array = new int[]{3, 7, 1, 4, 8, 1, 5, 3, 9, 2, 1};
        //7,8,4,8,9,5,9,9,9,2,1

        int result[] = FindNextGreaterNumber.nextGreaterElements(array);
        for (int number : result) {
            System.out.print(number + ",");
        }
        System.out.println();
    }
}
