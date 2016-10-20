package org.cshah.algorithms.string;

/**
 * Created by chirag on 10/12/16.
 */
public class StringCompression {

    public static String compressString(String input) {
        int size = countCompression(input);
        if (size >= input.length())
            return  input;

        StringBuffer sb = new StringBuffer();
        char last = input.charAt(0);
        int count = 1;
        for (int i=1; i < input.length(); i++) {
         if (last == input.charAt(i)) {
             count++;
         } else {
             sb.append(last);
             sb.append(count);
             count=1;
             last = input.charAt(i);
         }
        }

        sb.append(last);
        sb.append(count);

        return sb.toString();

    }

    public static int countCompression(String input) {
        int count =0;
        if (input == null || input.length() == 0)
            return  count;

        char last = input.charAt(0);
        count = 1;
        int size = 0;
        for (int i=1; i < input.length(); i++) {
            if (input.charAt(i) != last) {
                count = 1;
                last = input.charAt(i);
                size += 1 + String.valueOf(count).length();

            } else {
                count++;
            }
        }

        size += 1 + String.valueOf(count).length();

        System.out.println("SIZE " + size);
        return size;
    }
    public static void main(String args[]) {
        String input = "aaabbcccc";
        System.out.println("Input " + input + " --- Output " + StringCompression.compressString(input));
        input = "aabbcc";
        System.out.println("Input " + input + " --- Output " + StringCompression.compressString(input));

    }
}
