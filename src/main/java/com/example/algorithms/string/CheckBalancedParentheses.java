package com.example.algorithms.string;

import java.util.Stack;

/**
 * Created by chirag on 9/11/16.
 */
public class CheckBalancedParentheses {

    public static boolean isValid(String s,Stack<Character> stack) {
        if (s == null || s.length() == 0 )
            return  true;

        char c = s.charAt(0);
        switch (c) {
            case  '{' :
                stack.push(c);
                break;
            case  '(' :
                stack.push(c);
                break;
            case ')': {
                if (stack.isEmpty())
                    return false;

                Character c1 = stack.peek();
                if (c1 != '(')
                    return false;

                if (c1 == '(')
                    stack.pop();
                break;
            }
            case '}': {
                if (stack.isEmpty())
                    return false;

                Character c1 = stack.peek();
                if (c1 != '{')
                    return false;

                if (c1 == '{')
                    stack.pop();

                break;
            }
        }//switch


        return isValid(s.substring(1, s.length()), stack);
    }


    public static void main(String args[]) {
        String s = "{()}";
        boolean bvalue = isValid(s, new Stack<Character>());
        System.out.println(s +  " is Valid " + bvalue);
        s = "{(})";
        bvalue = isValid(s, new Stack<Character>());
        System.out.println(s +  " is Valid " + bvalue);

    }
}
