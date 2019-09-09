package org.cshah.algorithms.leetcode;

public class StringValidPalinDrome {

    public boolean isPalindrome(String s) {
        int start =0;
        int end = s.length() -1;

        while (start < end) {
            if (!isValidChar(s.charAt(start))) {
                start++;
                continue;
            }

            if (!isValidChar(s.charAt(end))) {
                end--;
                continue;
            }

            if (getChar(s.charAt(start)) != getChar(s.charAt(end)))
                return false;

            start++;
            end--;

        }

        return true;
    }

    public char getChar(char c) {
        if ( c >= 'a' && c <= 'z')
            return (char)(c - 32);

        return c;
    }

    public boolean isValidChar(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') || ( c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        StringValidPalinDrome stringValidPalinDrome = new StringValidPalinDrome();
        String str = "A man, a plan, a canal: Panama";
        System.out.print(stringValidPalinDrome.isPalindrome(str));

        str = "race a car";
        System.out.print(stringValidPalinDrome.isPalindrome(str));

    }
}
