package org.cshah.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This problem was asked by Facebook.
 *
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 *
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 *
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class EncodeDecodeMessage {
    private String charMap = "#abcdefghijklmnopqrstuvwxyz";

    public Set<String> decodeMessage(String message) {

        decodeMsgRec(message, 0, message.length()-1,"");

        return  null;
    }

    public void decodeMsgRec(String message, int start, int end, String newStr) {
        if (end < start ) {
            System.out.println(newStr);
            return;
        }

        int c1 = Integer.parseInt(message.charAt(end) + "");
        if (c1 <= 26 ) {
            decodeMsgRec(message, start, end-1,  charMap.charAt(c1) + newStr);
        }

        if (end > 0) {
            int c2 = Integer.parseInt(message.charAt(end - 1) + "" + message.charAt(end) + "");
            if (c2 <= 26) {
                decodeMsgRec(message, start, end - 2, charMap.charAt(c2) + newStr);
            }
        }

    }
    public static void main(String args[]) {
        EncodeDecodeMessage encodeDecodeMessage = new EncodeDecodeMessage();
        encodeDecodeMessage.decodeMessage("111");
    }
}
