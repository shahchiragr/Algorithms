package org.cshah.algorithms.leetcode.medium;

import org.cshah.algorithms.string.LongestPalindrome;

public class LongestPalimSubSeq {
    public int longestPalindromeSubseq(String s) {
        char[] str = s.toCharArray();
        int T[][] = new int[str.length][str.length];
        for(int i=0; i < str.length; i++){
            T[i][i] = 1;
        }
        for(int l = 2; l <= str.length; l++){
            for(int i = 0; i < str.length-l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && str[i] == str[j]){
                    T[i][j] = 2;
                }else if(str[i] == str[j]){
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }

        for (int row=0; row < str.length; row++) {
            for (int col=0; col < str.length; col++) {
                System.out.print( T[row][col]);
            }
            System.out.println();
        }
        return T[0][str.length-1];
     }



    public int palindromeSubSeqRec(char str[], int start, int end) {
        if (end == 1)
            return 1;

        if (end ==0 )
            return  0;

        if (str[start] == str[start+end-1]) {
            int count = 2+ palindromeSubSeqRec(str, start+1, end-2);
            return count;
        } else {
            return  Math.max(palindromeSubSeqRec(str, start+1, end-1), palindromeSubSeqRec(str, start, end-1));
        }
    }
    public static void main(String args[]) {
        LongestPalimSubSeq longestPalimSubSeq = new LongestPalimSubSeq();

        int result = longestPalimSubSeq.longestPalindromeSubseq("aabcdcbg");
        System.out.println("Longest Palindrome SubSeq  " + result);

        result = longestPalimSubSeq.longestPalindromeSubseq("bbbbab");
        System.out.println("Longest Palindrome SubSeq  " + result);

    }
}
