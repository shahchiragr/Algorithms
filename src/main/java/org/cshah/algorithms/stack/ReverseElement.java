package org.cshah.algorithms.stack;

import java.util.Stack;

/**
 * Created by chirag on 9/13/16.
 */
public class ReverseElement {

    public static void printStack(Stack<Integer> stack) {
        int size = stack.size();
        for (int i=0; i< size; i++) {
            System.out.print(stack.get(i) + " ");
        }

        System.out.println();
    }

    public static void reverseElement(Stack<Integer> stack) {

        if (stack.isEmpty())
            return;

            Integer item1 = popItem(stack);

            reverseElement(stack);

            stack.push(item1);

    }

    public static Integer popItem(Stack<Integer> stack){
        Integer top = stack.pop();

        if (stack.isEmpty()) {
            return top;
        } else {
            Integer bottom = popItem(stack);
            stack.push(top);
            return bottom;
        }

    }

     public static void reverseAllElement(Stack<Integer> stack, int size, int start, int end) {
        if (stack.isEmpty())
            return;

        if (start <= end)
            return;

        Integer item1 = stack.get(start);
        Integer item2 = stack.get(end);

        if (!stack.isEmpty()) {
            item2 = stack.pop();
        }

        reverseElement(stack);

        stack.push(item1);
        if (item2 != null) {
            stack.push(item2);
        }
    }

    public static void main(String args[] ) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        ReverseElement.printStack(stack);

        ReverseElement.reverseElement(stack);
        ReverseElement.printStack(stack);


    }
}
