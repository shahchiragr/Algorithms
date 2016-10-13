package org.cshah.algorithms.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by chirag on 9/28/16.
 */
public class AsteriskExpr {

    public static void printNumber(String input) {
        if (input == null || input.isEmpty() ||input.indexOf("***") >=0) {
            System.out.println("Syntax Error");
            return;
        }
        char data[] = input.toCharArray();
        Stack<Long> numberStack = new Stack<Long>();
        Stack<Integer> astrickStack = new Stack<Integer>();

        if (data.length ==0 || data[0] == '*' || data[data.length-1] == '*') {
            System.out.println("Syntax Error");
            return;
        }

        StringBuffer sb = new StringBuffer();

        for (int i=0; i < data.length;i++) {

            if (data[i] != '*') {
                sb.append(data[i]);
                if (i+1 >= data.length) {
                    String sNum = sb.toString();

                    numberStack.push(Long.parseLong(sNum));
                    calculate(numberStack, astrickStack);
                }
            } else {
                String sNum = sb.toString();
                numberStack.push(Long.parseLong(sNum));
                sb = new StringBuffer();

                calculate(numberStack, astrickStack);

                int count =0;
                int j = i;
                while (j < data.length && data[j] == '*') {
                    count++;
                    j++;
                }

                if (count > 2) {
                    System.out.println("Syntax Error");
                    return;
                }

                if (count == 2) {
                    i = j-1;
                }
                astrickStack.push(count);

            }
        }

        long totalSum = 1;

        for (int i=0; i< numberStack.size(); i++) {
            System.out.print(numberStack.elementAt(i) + " ");
            totalSum *= numberStack.elementAt(i);
        }
        System.out.println();

        for (int j=0; j < astrickStack.size(); j++) {
            System.out.print(astrickStack.elementAt(j) + " ");
        }

        System.out.println();;

        System.out.println(totalSum%(1000000000+7));

    }


    public static void calculate(Stack<Long> numberStack, Stack<Integer> astrickStack) {
        if (!astrickStack.isEmpty() && astrickStack.peek() == 2) {
            astrickStack.pop();
            long d1 = numberStack.pop();
            long d2 = numberStack.pop();
            long sum =1;
            for (int k=1; k <=d1; k++) {
                sum *= d2;
            }

            numberStack.push(sum);
        }


    }
    public static void main(String args[]) {
//        Scanner scanner = new Scanner(System.in);
//        int count = scanner.nextInt();
//
//        for (int i = 0; i < count; i++) {
//            printNumber(scanner.next());
//        }

            printNumber("2**3**2*2**2");
        String sArray[] = new String[] {"", "" +
                "2*2**2*2**2**2**2*1*2*2*2**2","3**2", "3*2", "3*2**3**2*5", "3**2*2**2", "3**2*2**2*","2**10", "*2*1","2**3**2*2**2", "1000**20"};
//        String input = "3*2**3**2*5";
        for (String ss : sArray) {
            System.out.print("OUTPUT FOR  " + ss + "  " );
//            printNumber(ss);
        }
    }


    public static boolean isNumber(Character c) {
        return (c >= '0' && c >='9');
    }
}
