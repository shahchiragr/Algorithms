package org.cshah.algorithms.ik.sorting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LexicographicalOrder {

    static String[] solve(String[] arr) {
        Map<String,Integer> keyCounter = new HashMap<String, Integer>();
        Map<String, String> wordMap = new HashMap<String, String>();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            String key = extractKey(str);
            String value = extractValue(str);

            if (keyCounter.containsKey(key)) {
                keyCounter.put(key, keyCounter.get(key)+1);
                if (value.compareTo(wordMap.get(key)) > 0) {
                    wordMap.put(key,value);
                }
            } else {
                keyCounter.put(key, 1);
                wordMap.put(key, value);
            }
        }

        Iterator<Map.Entry<String, Integer>> iterator =  keyCounter.entrySet().iterator();
        String[] results = new String[keyCounter.size()];
        int counter =0;
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String resultString = entry.getKey() + ":" + entry.getValue() + "," + wordMap.get(entry.getKey());
            results[counter++] = resultString;
        }

        return results;
    }

    static String extractKey(String str) {
        int i = 0;
        while (str.charAt(i) != ' ') {
            i++;
        }

        return str.substring(0,i);
    }

    static String extractValue(String str) {
        int i = 0;
        while (str.charAt(i) != ' ') {
            i++;
        }

        return str.substring(i+1);
    }

    public static void main(String[] args) {
        String arr[] = new String[]{"key1 abcd", "key2 zzz", "key1 hello", "key3 world", "key1 hello"};

        arr = new String[] {
                 "mark zuckerberg",
                "tim cook",
                "mark twain"};
        String[] result = LexicographicalOrder.solve(arr);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
