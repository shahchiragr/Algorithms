package org.cshah.algorithms.leetcode;

import java.util.Stack;

public class ValidateParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return  true;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (char c : chars) {
            switch (c) {
                case  '{' :
                case  '[' :
                case  '(' :
                    stack.push(c);
                    break;

                case  '}':
                case  ']':
                case  ')': {
                    if (stack.isEmpty())
                        return  false;
                    char c1 = stack.pop();
                    switch (c) {
                        case  '}':
                            if (c1 != '{')
                                return false;
                         break;

                        case  ']':
                            if (c1 != '[')
                                return false;
                            break;

                        case  ')':
                            if (c1 != '(')
                                return false;
                            break;

                    }
                }
            }

        }

        if (!stack.isEmpty())
            return  false;
        return  true;
    }


    public static void main(String[] args) {
        ValidateParentheses validateParentheses = new ValidateParentheses();
        System.out.println(validateParentheses.isValid("()[]{}"));
        System.out.println(validateParentheses.isValid("()"));
        System.out.println(validateParentheses.isValid("{()[]}"));
        System.out.println(validateParentheses.isValid("()]{}"));
        System.out.println(validateParentheses.isValid("()[{}"));
    }
}
