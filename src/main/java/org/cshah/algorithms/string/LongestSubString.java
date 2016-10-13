package org.cshah.algorithms.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chirag on 1/26/15.
 */
public class LongestSubString {

    public static int lengthOfLongestSubstringDP(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
                System.out.println("Found " + s.charAt(j) + ":" + map.get(s.charAt(j)) + "; i is : " + i);

            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring(String s) {
        boolean[] flag = new boolean[256];

        int result = 0;
        int j = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (flag[c]) {
                result = Math.max(result, i - j);
                for (int k = j; k < i; k++) {
                    if (arr[k] == c) {
                        j = k + 1;
                        break;
                    }
                    flag[arr[k]] = false;
                }
            } else {
                flag[c] = true;
            }
        }

        result=Math.max(arr.length-j,result);

        return result;
    }

    public static void main(String args[]) {
        System.out.println(LongestSubString.lengthOfLongestSubstring("abcda"));
        System.out.println(LongestSubString.lengthOfLongestSubstring("abcdeb"));

        System.out.println(LongestSubString.lengthOfLongestSubstringDP("abcda"));
        System.out.println(LongestSubString.lengthOfLongestSubstringDP("abcdeb"));

    }
}
