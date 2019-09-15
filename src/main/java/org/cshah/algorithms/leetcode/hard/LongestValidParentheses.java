package org.cshah.algorithms.leetcode.hard;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        String s = "(()";
        System.out.println(longestValidParentheses.longestValidParentheses(s));

        s = "(())";
        System.out.println(longestValidParentheses.longestValidParentheses(s));

        s = ")()())";
        System.out.println(longestValidParentheses.longestValidParentheses(s));

        s = "(((((((()";
        System.out.println(longestValidParentheses.longestValidParentheses(s));

        s = "(((((((";
        System.out.println(longestValidParentheses.longestValidParentheses(s));

        s = "))))";
        System.out.println(longestValidParentheses.longestValidParentheses(s));

        s = "(()())()";
        System.out.println(longestValidParentheses.longestValidParentheses(s));

        s = "()(()";
        System.out.println(longestValidParentheses.longestValidParentheses(s));

    }
}
