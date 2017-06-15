package org.cshah.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by chirag on 6/14/17.
 // Given an NxN board of letters, find all words (boggle)
 // e.g.,
 // given :
 //   a b c
 //   d o g
 //   e l g
 //
 // words are formed by joining letters that touch each other (up, down, left, right),
 //    using a given letter only once per word
 //
 // return:
 //     bog, boggle, dog, god, lob, bad, dab, bode, abode, ...

 */
public class MatrixToDictionaryWordFind {

    private static final HashSet<String> dictionary = new HashSet<String>();


    public static List<String> getAvailableWords(char[][] matrix) {
        List<String> returnList = new ArrayList<String>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i=0; i< matrix.length; i++) {
            for (int j=0; j < matrix[i].length;j++) {
                StringBuffer sb = new StringBuffer();
                getWordsFromMatrix(i,j, matrix, visited,sb, returnList );
            }

        }
        return returnList;


    }

    public static void getWordsFromMatrix(int row, int column, char[][] matrix, boolean[][] visited, StringBuffer sb, List<String> returnList) {
        if ( row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length )
            return;

        if (visited[row][column])
            return;

        visited[row][column] = true;
        sb.append(matrix[row][column]);

        if (isWordPresent(sb.toString()) && !returnList.contains(sb.toString())) {
            returnList.add(sb.toString());
        }


            getWordsFromMatrix(row-1, column-1, matrix, visited, sb,returnList);
            getWordsFromMatrix(row-1, column, matrix, visited, sb,returnList) ;
            getWordsFromMatrix(row-1, column+1, matrix, visited, sb,returnList) ;
            getWordsFromMatrix(row, column-1, matrix, visited, sb,returnList) ;
            getWordsFromMatrix(row, column+1, matrix, visited, sb,returnList) ;
            getWordsFromMatrix(row+1, column-1, matrix, visited, sb,returnList) ;
            getWordsFromMatrix(row+1, column, matrix, visited, sb,returnList) ;
            getWordsFromMatrix(row+1, column+1, matrix, visited, sb,returnList) ;


        sb.setLength(sb.length()-1);
        visited[row][column] = false;
    }

    public static boolean isWordPresent(String word) {
        if (word == null || word.length() == 0)
            return false;

        return dictionary.contains(word);

    }
    public static void main(String args[]) {
        dictionary.add("bog");
        dictionary.add("boggle");
        dictionary.add("dog");
        dictionary.add("god");
        dictionary.add("'lob");
        dictionary.add("bad");
        dictionary.add("dab");
        dictionary.add("bode");
        dictionary.add("abode");

        char[][] matrix = new char[][] {
                {'a','b','c'},
                {'d','o','g'},
                {'e','l','g'}
        };

        List<String> list = MatrixToDictionaryWordFind.getAvailableWords(matrix);
        for (String s : list) {
            System.out.println("Word Found... " + s);
        }
    }
}
