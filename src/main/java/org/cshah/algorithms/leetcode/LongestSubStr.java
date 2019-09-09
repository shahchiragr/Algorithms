package org.cshah.algorithms.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestSubStr {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] cArray = s.toCharArray();
        int maxLength = 0;
        int windowStart =0;
        for (int windowEnd=0; windowEnd < cArray.length; windowEnd++) {
            char c = s.charAt(windowEnd);
            if (map.containsKey(c)) {
                windowStart = Math.max(windowStart, map.get(c)+1);
            }

            map.put(c, windowEnd);
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubStr longestSubStr = new LongestSubStr();
        System.out.println(longestSubStr.lengthOfLongestSubstring("abcabc"));
        System.out.println(longestSubStr.lengthOfLongestSubstring("abcbfg"));
        System.out.println(longestSubStr.lengthOfLongestSubstring("abcd"));
    }
}
