package org.cshah.algorithms.string;

/**
 * Created by chirag on 10/12/16.
 *
 * Replace space with %20
 */
public class ReplaceSpace {

    public static String replaceSpace(String str) {
        int spaceCount = countSpace(str);

        char[] output = new char[str.length() + spaceCount*2];
        char[] input = str.toCharArray();

        int j = output.length-1;
        for (int i=input.length-1;i >=0; i--) {
            if (input[i] == ' ') {
                output[j--] = '0';
                output[j--] = '2';
                output[j--] = '%';
            } else {
                output[j--] = input[i];
            }
        }

        return new String(output);

    }

    private static int countSpace(String input) {
        if (input == null || input.length() ==0)
            return  0;

        int count = 0;
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (c == ' ')
                count++;
        }

        return  count;
    }
    public static void main(String args[]) {
        String input = "This is test program";
        String output = ReplaceSpace.replaceSpace(input);

        System.out.println("Input " + input + "--- Output " + output);
    }
}
