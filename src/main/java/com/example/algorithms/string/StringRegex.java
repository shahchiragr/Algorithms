package com.example.algorithms.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chirag on 7/2/14.
 */
public class StringRegex {

    public void HTMLRegex(String str) {
        Pattern pattern = Pattern.compile("<(\"[^\"]*\"|'[^']*'|[^'\">])*>");
        Matcher matcher =pattern.matcher(str);

        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }
    }

    public int patternMatch(char[] inputString, char[] pattern) {
        int numberOfMatches = 0;
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < inputString.length; j++) {
                if (i == j && pattern[i] == inputString[j]) {
                    numberOfMatches++;
                }
            }
        }
        /*
        if (inputString.length >= pattern.length) {
            return numberOfMatches == pattern.length? 1 +  patternMatch(inputString.slice(1)[1], pattern) : patternMatch(inputString.slice(1)[1], pattern);
        } else {
            return numberOfMatches == pattern.length? 1 : 0;
        }
        */

        return numberOfMatches;

    }

    /*

    char[] inputString = ['a','a','a','b','a','b','a','a','b']
char[] pattern = {'a','a'}

output = 3

public int patternMatch(char[] inputString, char[] pattern) {
    int numberOfMatches = 0;
    for (int l = 0; l < inputString.lenght(); l++) {
        int numberOfContinuesMatchingChar = 0;
        for (int i = 0; i < pattern.length(); i++) {
            for (int j = l; j < inputString.length(); j++) {
                if (pattern[i] == inputString[j]) {
                    numberOfContinuesMatchingChar++;
                    //
                }
            }
        }
        if (numberOfContinuesMatchingChar == pattern.length()) {
            numberOfMatches++;
        }
    }

    return numberOfMatches;
}
     */
    public static void main(String args[]) {
        StringRegex regex = new StringRegex();
      //  regex.HTMLRegex("<h1>hi this is chirag</h1>test<begin>ge</begin>");
        System.out.println("OUT : " +regex.patternMatch("aabaabaab".toCharArray(), "a".toCharArray()));
    }
}
