package org.cshah.algorithms.ik.dp;

import java.util.*;

/**

 Problem Statement:


 You are given a dictionary set dictionary that contains dictionaryCount distinct words and another string txt.
 Your task is to count the possible number of the word-breaks of the txt string in such a way that all the word occur in
 a continuous manner in the original txt string and all these words exist in our dictionary set dictionary.


 In short, you have to split the string txt using ‘ ‘(single white space delimiter) in such a way that every segment (word) exists
 in our dictionary.

 The same word from the dictionary can be used multiple times when splitting the given string.


 Example: Suppose our Dictionary is {“to”, “do”, “todo”}

 and txt is “totodo” then it can also be segmented as

 “to to do”. Here the word “to” from the dictionary is being used twice.


 Input/Output Format For The Function:


 Input Format:

 The first parameter of the function that is to be implemented is an integer dictionaryCount denoting, the number of words in our
 dictionary. The second parameter is an array of strings dictionary, denoting the list of words in our dictionary and the last parameter
 is a string txt, denoting the text string that is to be segmented.


 Output Format:

 Return an integer denoting all different possible word-break arrangements for the txt string. This integer could be large so output
 it modulo 10^9 + 7.


 Input/Output Format For The Custom Input:


 Input Format:


 The first line of the input contains one single integer denoting dictionaryCount, the number of words in our dictionary.

 Next dictionaryCount lines contain strings denoting words in our dictionary. Next line contains one single string denoting the txt string.

 If dictionaryCount = 2 , dictionary = [“hello” , “world”] and

 txt = “helloworld” then custom input format will be:


 2

 hello

 world

 helloworld


 Output Format:

 Print one integer denoting all different possible word-break arrangements for the txt string.

 For the above-provided custom input, output there is only one way to partition the txt string ( “hello world”), so the output will be:


 1

 Constraints:

 1 <= dictionaryCount <= 200000
 1 <= length(txt) <= 2000
 1<= length of words in dictionary <= 100
 All the characters in txt and words in dictionary are lower case English alphabets.

 Sample Test Case:

 7

 google

 home

 googlehome

 is

 awe

 some

 awesome

googlehomeisawesome


 Sample Output:

 4


 Explanation:

 There are only 4 possible segmentations possible for the given txt and 4 % 1000000007 = 4. All four of which are mentioned below:

 google home is awe some
 google home  is awesome
 googlehome is awe some
 googlehome is awesome


 Consider first word-break arrangement: “google home is awe some”

 Here all the words: google, home, is, awe and some exist in our dictionary and these words are continuous substrings of the txt
 string “googlehomeisawesome”.


 Similarly, other three word-breaks satisfy the same conditions and hence are valid word-breaks of the given string
 */
public class WordBreakCount {

    public static int wordBreakCount(List<String> dictionary, String txt) {
//        return  wordBreakCountRec(dictionary, txt, new ArrayList<String>());
        return  wordBreakCountDP(dictionary, txt);

    }

    public static int wordBreakCountRec(List<String> dictionary, String txt, List<String> resultList) {
        if (txt.isEmpty()) {
            for (String str : resultList) {
                System.out.print(str + " ");
            }
            System.out.println();
            return 1;
        }

        int total = 0;
        for (String dictWord : dictionary) {
            if (txt.length() >= dictWord.length() &&  txt.substring(0, dictWord.length()).equals(dictWord)) {
                resultList.add(dictWord);
                total += wordBreakCountRec(dictionary, txt.substring(dictWord.length()), resultList);
                resultList.remove(resultList.size()-1);
            }
        }

        return  total;
    }

    public static int wordBreakCountDP(List<String> dictionary, String txt) {
        Set<String> dictionaryHashSet = new HashSet<String>(dictionary);
        int maxlen = 0;

        long mod = (long)Math.pow(10, 9) + 7l;

        for(String word: dictionary) {
            maxlen = Math.max(maxlen, word.length());
        }

        long[] table = new long[txt.length()+1];
        table[txt.length()] = 1;

        Vector<String>[] sol = new Vector[txt.length()];

        for(int i=txt.length()-1; i>=0; i--) {
            for(int j=i+1; j<=txt.length() && j-i<=maxlen; j++) {
                if(dictionaryHashSet.contains(txt.substring(i,j))) {
                    if(sol[i]==null) {
                        sol[i] = new Vector<String>();
                    }
                    sol[i].add(txt.substring(i,j));
                    table[i] += table[j];
                //    System.out.println(" i and j "+ i +  "," + j + " : " + table[i] + " : " + table[i]%mod);
                    table[i] %= mod;
                }
            }
        }

//        System.out.println(Arrays.toString(Arrays.stream(table,0,txt.length()).toArray()));
        print(0,sol,"");
//        System.out.println(table[0]);
        return (int)table[0];
    }

    public static void print(int i, Vector<String>[] sol, String prefix) {
        if(i>=sol.length) {
            System.out.println(prefix);
            return;
        }
        for(String word: sol[i]) {
            print(i+word.length(), sol, prefix + word + "\t");
        }
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("google");
        dictionary.add("home");
        dictionary.add("googlehome");
        dictionary.add("is");
        dictionary.add("awe");
        dictionary.add("some");
        dictionary.add("awesome");

        String txt = "googlehomeisawesome";

        int count = WordBreakCount.wordBreakCount(dictionary, txt);
        System.out.println("Total count " + count);

    }
}
