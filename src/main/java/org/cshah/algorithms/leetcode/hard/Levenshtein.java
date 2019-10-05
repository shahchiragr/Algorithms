package org.cshah.algorithms.leetcode.hard;

public class Levenshtein {

    public int findMinDistance(String str1, String str2, int str1Len, int str2Len) {
        if (str1.length()-1 == str1Len) return  str2.length() - str2Len;

        if (str2.length()-1 == str2Len) return str1.length() - str1Len;

            if (str1.charAt(str1Len) == str2.charAt(str2Len)) {
                return findMinDistance(str1, str2, str1Len + 1, str2Len + 1);
            }

        int total = 1 +
                Math.min(
                        Math.min(
                                findMinDistance(str1, str2, str1Len, str2Len+1),  /* Insert into next string*/
                                findMinDistance(str1,str2,str1Len+1,str2Len)  /* Delete from the first string*/
                        ),
                findMinDistance(str1,str2,str1Len+1, str2Len+1) /* Replace character */
                );

        return total;
    }


    public static void main(String[] args) {
        String str1 = "ball";
        String str2 = "car";

        Levenshtein levenshtein = new Levenshtein();
        System.out.println(levenshtein.findMinDistance(str1,str2,0,0));
        System.out.println(levenshtein.findMinDistance("trump","bump",0,0));

    }
}
