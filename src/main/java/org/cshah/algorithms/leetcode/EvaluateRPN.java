package org.cshah.algorithms.leetcode;

import java.util.Stack;

public class EvaluateRPN {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0)
            return  0;

        Stack<String> stringStack = new Stack<String>();
        for (String s: tokens) {

            if ( isOperator(s)) {
                String str2 = stringStack.pop();
                String str1 = stringStack.pop();

                int value = getValue(str1,str2,s);

                stringStack.push("" + value);
            } else {
                stringStack.push(s);
            }
        }

       return Integer.parseInt(stringStack.pop());
    }

    public int getValue(String str1, String str2, String operator) {
        int int1 = Integer.parseInt(str1);
        int int2 = Integer.parseInt(str2);

        if ("+".equals(operator))
            return int1 + int2;

        if ("-".equals(operator))
            return int1 - int2;

        if ("*".equals(operator))
            return int1 * int2;

        if ("/".equals(operator))
            return  int1/int2;

        return 0;
    }
    public  boolean isOperator(String s) {
        return "+".equals(s) ||
                "*".equals(s) ||
                "/".equals(s) ||
                "-".equals(s) ;

    }
    public static void main(String[] args) {

        EvaluateRPN evaluateRPN = new EvaluateRPN();
        String sArray[] = new String[] {"2", "1", "+", "3", "*"};
        System.out.println(" == > " + evaluateRPN.evalRPN(sArray));

        sArray = new String[] {"4", "13", "5", "/", "+"};
        System.out.println(" == > " + evaluateRPN.evalRPN(sArray));


        sArray = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(" == > " + evaluateRPN.evalRPN(sArray));

    }
}
