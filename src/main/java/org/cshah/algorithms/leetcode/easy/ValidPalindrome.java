package org.cshah.algorithms.leetcode.easy;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome {
    public boolean validPalindrome(String str) {
        if (str == null || str.length() ==0)
            return  false;

        char[] chars = str.toCharArray();
        int start =0;
        int end = str.length()-1;


        while (start <= end) {

            if (chars[start] != chars[end]) {
              return isValidPalindrome(chars,start+1, end ) || isValidPalindrome(chars, start, end-1) ;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isValidPalindrome(char[] chars, int start, int end) {
        while (start <= end) {
            if (chars[start] != chars[end])
                return false;
            start++;
            end --;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String str = "abca";
        System.out.println(validPalindrome.validPalindrome(str));
         str = "ababacd";
        System.out.println(validPalindrome.validPalindrome(str));
        str = "aba";
        System.out.println(validPalindrome.validPalindrome(str));

    }
}

