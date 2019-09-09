package org.cshah.algorithms.leetcode;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> returnList = new ArrayList<List<String>>();
        Map<String, Integer> stringMap = new HashMap<String,Integer>();

        int listIndexCounter = 0;
        for (int i=0; i < strs.length; i++) {
            String str = strs[i];
            String sortStr = sort(str);
            if (stringMap.containsKey(sortStr)) {
                returnList.get(stringMap.get(sortStr)).add(str);
            }   else {
                List<String> stringList = new ArrayList<String>();
                stringList.add(str);
                returnList.add(listIndexCounter, stringList);
                stringMap.put(sortStr, listIndexCounter);
                listIndexCounter++;
            }
        }

        return returnList;
    }

    public String sort(String str) {
        char[] cArray = str.toCharArray();
        Arrays.sort(cArray);
        return new String(cArray);
    }

    public static void main(String[] args) {
        String[]  input = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();

    //    System.out.println(groupAnagrams.sort("eat"));
        List<List<String>> lists = groupAnagrams.groupAnagrams(input);
        for (List<String> list :lists) {
            for (String str: list) {
                System.out.print(str + " ");
            }
            System.out.println("");
        }
    }
}
