package org.cshah.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * For DP check this link
 * https://www.youtube.com/watch?v=lDYIvtBVmgo
 */
public class PalindromicDecompositions {

    static boolean isPalindrome(String str, int start, int end) {

        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }

    static String[] generate_palindromic_decompositions(String s) {
        List<String> list = new ArrayList<String>();
        generate_palindromic_decompositions_util(s, 0, "", list);

        String arr[] = new String[list.size()];
        arr = list.toArray(arr);
        return arr;
    }

    static void generate_palindromic_decompositions_util(String str, int pos, String curr_str, List<String> results) {

        if (pos == str.length()) {
            results.add(curr_str.substring(0, curr_str.length()-1));
            return;
        }

        for (int i=pos; i < str.length();i++) {
            if (isPalindrome(str, pos,i)) {
                String partialStr = str.substring(pos, i+1);
                generate_palindromic_decompositions_util(str, i+1, curr_str + partialStr + "|", results);
            }
        }
    }
    /*
    static void generate_palindromic_decompositions_util(String str, int pos,List<String> partialDecom, List<List<String>> results) {

        if (pos == str.length()) {
            results.add(new ArrayList<>(partialDecom));
            return;
        }

        for (int i=pos; i < str.length();i++) {

            if (isPalindrome(str, pos,i)) {
                String partialStr = str.substring(pos, i+1);

                partialDecom.add(partialStr);

                generate_palindromic_decompositions_util(str, i+1, partialDecom, results);

                partialDecom.remove(partialDecom.size()-1);
            }
        }
    } */

    public static void main(String[] args) {
       String arr[] = PalindromicDecompositions.generate_palindromic_decompositions("ababa");
       for (String str :arr) {
           System.out.println(str);
       }
    }
}
