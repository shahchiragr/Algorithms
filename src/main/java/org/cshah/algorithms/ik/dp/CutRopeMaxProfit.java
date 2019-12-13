package org.cshah.algorithms.ik.dp;

/**

 Problem Statement:

 Given a rope with length n, find the maximum value maxProduct, that can be achieved for product len[0] * len[1] * ... * len[m - 1],
 where len[] is the array of lengths obtained by cutting the given rope into m parts.


 Note that

 there should be atleast one cut, i.e. m >= 2.
 All m parts obtained after cut should have non-zero integer valued lengths.

 Input/Output Format For The Function:


 Input Format:


 There is only one argument, an integer denoting n.


 Output Format:

 Return a number maxProduct, denoting maximum possible product as asked in the problem.


 Input/Output Format For The Custom Input:


 Input Format:


 There should be only one line, containing an integer n, denoting length of rope.


 If n = 5, then input should be:

 5

 Output Format:

 There will be one line, containing an integer maxProduct.

 For input n = 5, output will be:

 6

 Constraints:

 2 <= n <= 111
 We have to cut at least once. (2 <= m).
 Length of the rope, as well as the length of each part are in positive integer value. (i.e. can't do partial cuts.)

 Sample Test Case:

 Sample Input:

 4

 Sample Output:

 4

 Explanation:


 For n = 4, there are two cuts possible: 1 + 3 and 2 + 2.

 We'll pick 2 + 2, because their product 2 * 2 = 4 is greater than product of the first one 1 * 3 = 3.

 (So our m = 2, n[0] = 2 and n[1] = 2 and product is n[0] * n[1] = 4.)

 Note:

 JavaScript solutions will give “Wrong Answer” for the test cases from 023 to 029 because the answers exceed Number.MAX_SAFE_INTEGER.
 So, if your JavaScript solution passes all the previous test cases and for the test cases from 023 to 029 the answers are only slightly
 different (like 450283905890997300 vs 450283905890997363), then consider your solution as a correct solution.

 */
public class CutRopeMaxProfit {

    static long max_product_from_cut_pieces(int n) {
        long product[] = new long[n+1];
        product[1] = 1;

        for (int cut_rope_len=2; cut_rope_len<=n;cut_rope_len++) {

            for (int cut_length = 1; cut_length < cut_rope_len; cut_length++) {
                product[cut_rope_len] = Math.max(product[cut_rope_len], cut_length * product[cut_rope_len - cut_length]);
            }


            if (cut_rope_len != n) {
                product[cut_rope_len] = Math.max(product[cut_rope_len], cut_rope_len);
            }
        }
        return product[n];
    }

    public static  void main(String[] args) {
        int ropeSize = 6;
        long result = CutRopeMaxProfit.max_product_from_cut_pieces(ropeSize);
        System.out.println("result " + result);
    }
}
