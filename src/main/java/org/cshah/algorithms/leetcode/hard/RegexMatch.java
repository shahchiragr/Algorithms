package org.cshah.algorithms.leetcode.hard;

public class RegexMatch {

    public static boolean matches(String str, String pattern, int strIndex, int patternIndex) {
        if ( strIndex == str.length()) {
           int pIndex = patternIndex;
           while (pIndex < pattern.length() && pattern.charAt(pIndex) == '*') {
               pIndex++;
           }
            return pattern.length() == pIndex;
        }

        if (pattern.length() == patternIndex) {
            return str.length() == strIndex;
        }

        if (strIndex >= str.length() || patternIndex >= pattern.length())
            return false;

//        if (str.charAt(strIndex) != pattern.charAt(patternIndex) && pattern.charAt(patternIndex) != '*') {
//            return false;
//        }

        if (str.charAt(strIndex) == pattern.charAt(patternIndex) || (pattern.charAt(patternIndex) == '?')) {
            return matches(str, pattern, strIndex+1, patternIndex+1);
        } else if (pattern.charAt(patternIndex) == '*') {
            return matches(str, pattern, strIndex+1, patternIndex) ||
                    matches(str, pattern, strIndex, patternIndex+1) ;
        }

        return  false;
    }

    public static void matchPattern(String str, String pattern) {
        boolean result = matches(str, pattern,0,0);
        System.out.printf("String='%s' and  Pattern='%s' matches ==> %s \n", str, pattern, result);
    }
    public static void main(String[] args) {
        RegexMatch.matchPattern("abcsdfsdfd", "abc*d");
        RegexMatch.matchPattern("abcd", "abcd");
        RegexMatch.matchPattern("abcd", "abd");
        RegexMatch.matchPattern("abcd", "abcd*");
        RegexMatch.matchPattern("abcdxyzfgg", "abcd*f*g");
        RegexMatch.matchPattern("aaabc", "a*b*");
        RegexMatch.matchPattern("abcd", "ab??d");
    }
}
