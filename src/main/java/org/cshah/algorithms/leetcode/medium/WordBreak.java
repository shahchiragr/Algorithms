package org.cshah.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length()+1];
        arr[0] = true;

        for (int i=0; i < s.length();i++) {

            if (!arr[i])
                continue;

            for (String word : wordDict) {
                int len = word.length();
                int end = len + i;
                if (end > s.length() ) {
                    continue;
                }
       //         System.out.println("Dict word " + word + "  ==  " + s.substring(i,end) );

                if (s.substring(i,end).equals(word)) {
                    arr[end] = true;
                }
            }
        }

        int index =0;
        for (boolean b: arr) {
            System.out.print(index++ + "[" + b + "]," );
        }
        return arr[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> dict = new ArrayList<String>();
        dict.add("leet");
        dict.add("code");

       System.out.println(wordBreak.wordBreak("leetcode", dict));

        dict = new ArrayList<String>();
        dict.add("cats");
        dict.add("dog");
        dict.add("sand");
        dict.add("and");
        dict.add("cat");

        System.out.println(wordBreak.wordBreak("catsandog", dict));

        dict = new ArrayList<String>();
        dict.add("i");
        dict.add("am");
        dict.add("man");
        dict.add("good");
        dict.add("go");

        System.out.println(wordBreak.wordBreak("goodmaniam", dict));

    }
}
