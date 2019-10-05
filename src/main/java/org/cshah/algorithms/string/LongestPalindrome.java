package org.cshah.algorithms.string;

import java.util.PriorityQueue;

/**
 * Created by chirag on 1/24/16.
 *
 Method 2 ( Dynamic Programming )
 The time complexity can be reduced by storing results of subproblems. The idea is similar to this post. We maintain a boolean table[n][n] that is filled in bottom up manner. The value of table[i][j] is true, if the substring is palindrome, otherwise false. To calculate table[i][j], we first check the value of table[i+1][j-1], if the value is true and str[i] is same as str[j], then we make table[i][j] true. Otherwise, the value of table[i][j] is made false.

 // A dynamic programming solution for longest palindr.
 // This code is adopted from following link
 // http://www.leetcode.com/2011/11/longest-palindromic-substring-part-i.html

 Time complexity: O ( n^2 )
 Auxiliary Space: O ( n^2 )

 */
public class LongestPalindrome {

    /*

    https://leetcode.com/articles/longest-palindromic-substring/

    Approach #4 (Expand Around Center) [Accepted]

In fact, we could solve it in O(n^2) time using only constant space.

We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2n - 12n−1 such centers.

You might be asking why there are 2n - 12n−1 but not nn centers? The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as
''abba'' ) and its center are between the two 'b's.
     */
    public static String longestPalindromeDP(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /****************************************************************************/
    public static int longestPalindrome(String str) {
        int maxLength=1;
        int n = str.length();
        boolean table[][] = new boolean[n][n];

        for (int i=0; i<n;i++) {
            table[i][i] = true;
        }

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n-1; ++i)
        {
            if (str.charAt(i) == str.charAt(i+1))
            {
                table[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2. k is length
        // of substring
        for (int k = 3; k <= n; ++k)
        {
            // Fix the starting index
            for (int i = 0; i < n-k+1 ; ++i)
            {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str[i+1] to str[j-1] is a
                // palindrome
                if (table[i+1][j-1] && str.charAt(i) == str.charAt(j))
                {
                    table[i][j] = true;

                    if (k > maxLength)
                    {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        printTable(table,n);
        return maxLength;
    }

    private static void printTable(boolean table[][], int row) {
        for (int i=0; i < row; i ++) {
            for (int j=0; j< row; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
         }

        PriorityQueue p = new PriorityQueue();
    }




    public static void main(String args[]) {
        int num = LongestPalindrome.longestPalindrome("aabcdcbg");
        System.out.println("SIZE " + num);

    String result = LongestPalindrome.longestPalindromeDP("aabcdcbg");
    System.out.println("String  " + result);

         result = LongestPalindrome.longestPalindromeDP("bbbbab");
        System.out.println("String  " + result);

    }
}
