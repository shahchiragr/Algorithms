package org.cshah.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubSet {

    static String[] generate_all_subsets(String s) {
        String result = "";
        List<String> stringList = new ArrayList<String>();
        generateSubSet(s,result, stringList);

        String[] arr = new String[stringList.size()];
        arr = stringList.toArray(arr);
      return arr;

    }

    static void generateSubSet(String s, String resultString, List<String> stringList) {
        if (s.isEmpty()) {
            stringList.add(resultString);
            return;
        }

        generateSubSet(s.substring(1),resultString,stringList );

        generateSubSet(s.substring(1), resultString + s.charAt(0),stringList);
     }

    public static void main(String[] args) {
        String str = "xy";
        GenerateAllSubSet subSet = new GenerateAllSubSet();
        String result[] = subSet.generate_all_subsets(str);
        for (String ss: result) {
            System.out.println(ss);
        }
    }

}
