package org.cshah.algorithms.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chirag on 9/25/16.
 */
public class TwoChars {

    public static void selectCombination(List<Character> characterList, boolean[] used, char[] selectedList,int current, int max) {
        //     System.out.println("... " + (current+1) + ":" + max);
        if (current+1 > max) {
//              for (Character c : selectedList) {
//                  System.out.print(c + ":" );
//              }
//
//              System.out.println();
//              return;
        }

        for (int i=0; i < characterList.size(); i++) {
            if (used[i] == true) {
                continue;
            }

            used[i] = true;
            selectedList[current] = characterList.get(i);

            selectCombination(characterList, used, selectedList, current+1, max);

            used[i] =false;
        }
    }


    public static List<Character> findUniqueChar(String str) {
       List<Character> charList = new ArrayList<Character>();
       if (str == null || str.isEmpty()) {
           return charList;
       }
       for (int i=0; i < str.length(); i++) {
           if (!charList.contains(str.charAt(i))) {
               charList.add(str.charAt(i));
           }
        }

        //Character[] cArray = new Character[charList.size()];
        //charList.toArray(cArray);
        return charList;
   }


    public static List<String>  getList(List<Character> characterList) {
            List<String> keepList = new ArrayList<String>();

               for (int i=0; i < characterList.size()-1; i++) {
                    for (int j=i+1; j<characterList.size(); j++) {
                        keepList.add(new String("" + characterList.get(i).charValue() + characterList.get(j).charValue()));
                    }
                }

//                for (String ss: keepList) {
//                    System.out.println(ss);
//                }

                return keepList;
    }


    public static int isValid(String s) {
        if (s == null || s.isEmpty())
            return  0;

        for (int i=0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                return 0;
            }
        }

        return s.length();
    }

    public static void findMaxLength(String str) {
        List<Character> charactersList =TwoChars.findUniqueChar(str);
        List<String>  keepList = TwoChars.getList(charactersList);
        int maxCounter =0;

        if (charactersList.size() <= 2) {
            maxCounter = isValid(str);
        } else {
            for (int i = 0; i < keepList.size(); i++) {
                String newStr = str;
                String keepStr = keepList.get(i);

                for (Character c : charactersList) {
                    if (!keepStr.contains(c + "")) {
                        newStr = newStr.replaceAll(c + "", "");
                    }
                }

                int num = isValid(newStr);
                if (num > maxCounter) {
                    maxCounter = num;
                }
            }
        }

        System.out.println(maxCounter);
//        for (char c : charactersList) {
//            System.out.print(c + " " );
//        }
//        System.out.println();
//        boolean[] used = new boolean[charactersList.size()];
//        for (int i=0; i < used.length; i++) {
//            used[i]= false;
//        }
//        char[] selectedList = new char[2];

    }
    public static void main(String args[]) {
      String str = "beabeefeab";
        TwoChars.findMaxLength(str);
        TwoChars.findMaxLength("xyxy");
        TwoChars.findMaxLength("xyyx");

//        TwoChars.selectCombination(charactersList, used, selectedList, 0, 2);

    }
}
