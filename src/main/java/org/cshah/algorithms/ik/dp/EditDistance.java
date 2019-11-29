package org.cshah.algorithms.ik.dp;

public class EditDistance {

    public static int editDistRec(String str1,String str2, int str1Index, int str2Index) {
        if (str1.length() >= str1Index-1) return str2.length() -str2Index;

        if (str2.length() >= str2Index-1) return  str1.length() - str1Index;

        if (str1.charAt(str1Index) == str2.charAt(str2Index)) {
            return editDistRec(str1,str2, str1Index+1, str2Index+1);
        }

        int total = 1 +
             Math.min(Math.min( editDistRec(str1, str2, str1Index+1, str2Index),
                editDistRec(str1, str2, str1Index, str2Index+1)),
                editDistRec(str1, str2, str1Index+1, str2Index+1));

        return  total;
    }



    public static int editDistDP(String strWord1, String strWord2) {
        int[][] DP = new int[strWord1.length()+1][strWord2.length()+1];

        int counter=0;
        for (int col=strWord2.length(); col>=0; col--) {
            DP[strWord1.length()][col] = counter++;
        }

        counter=0;
        for (int row=strWord1.length(); row >=0; row--) {
            DP[row][strWord2.length()] = counter++;
        }

        for (int  i = strWord1.length()-1; i>=0; i--) {
            for (int j= strWord2.length()-1; j>=0; j--) {
                DP[i][j] = strWord1.charAt(i) == strWord2.charAt(j) ? DP[i+1][j+1] :
                        1 + Math.min(Math.min(DP[i][j+1], DP[i+1][j]), DP[i+1][j+1]);
            }
        }

        for (int i=0; i <= strWord1.length(); i++) {
          for (int j=0; j <= strWord2.length(); j++) {
              System.out.print(DP[i][j] + " | ");
            }
          System.out.println();
        }

        return DP[0][0];
    }
    public static void main(String[] args) {
        String str1 = "ball";
        String str2 = "car";
        int total = EditDistance.editDistRec(str1,str2,0,0);
        System.out.println("total " + total);

        System.out.println(EditDistance.editDistDP(str1,str2));
    }
}
