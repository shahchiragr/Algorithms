package org.cshah.algorithms.interviewcake;

import java.util.Stack;

public class FindNextGreaterElements {

    /**
     * Time complexity is O(n)
     * @param nums
     * @return
     */
    public static int[] findNextGreaterElements(int[] nums) {
        int[] results = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i=nums.length-1; i >=0; i--) {
            int currentNumber = nums[i];
            /*
            * If stack is not empty, then pop an element from stack.
            * If the popped element is smaller than next, then
            * a) print the pair
            * b) keep popping while elements are smaller and stack is not empty
            * */

            while ( !stack.isEmpty() && stack.peek() <= currentNumber) {
                stack.pop();
            }

            results[i] = stack.isEmpty()? currentNumber : stack.peek();

            stack.push(currentNumber);
        }

        return results;
    }

    public static void main(String[] args) {
        int[] array = new int[] {3,7,1,4,8,1,5,3,9,2,1};
        int[] results = FindNextGreaterElements.findNextGreaterElements(array);
        for (int number : results) {
            System.out.print(number + ", ");
        }
        System.out.println("");
    }
}

