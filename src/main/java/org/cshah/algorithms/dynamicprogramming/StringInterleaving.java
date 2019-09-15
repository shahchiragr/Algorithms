package org.cshah.algorithms.dynamicprogramming;

/**
 * CODE REFERENCE https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/TwoStringInterleavingToFormThird.java
 */
public class StringInterleaving {


    public boolean isInterleaved(char str1[], char str2[], char str3[]){
        boolean T[][] = new boolean[str1.length +1][str2.length +1];

        if(str1.length + str2.length != str3.length){
            return false;
        }

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length; j++){
                int l = i + j -1;
                if(i == 0 && j == 0){
                    T[i][j] = true;
                }
                else if(i == 0){
                    if(str3[l] == str2[j-1]){
                        T[i][j] = T[i][j-1];
                    }
                }
                else if(j == 0){
                    if(str1[i-1] == str3[l]){
                        T[i][j] = T[i-1][j];
                    }
                }
                else{
                    T[i][j] = (str1[i-1] == str3[l] ? T[i-1][j] : false) || (str2[j-1] == str3[l] ? T[i][j-1] : false);
                }
            }
        }
        return T[str1.length][str2.length];
    }

    public boolean isInterleavedRec(char[] str1, char[] str2, char[] str3, int pos1, int pos2, int pos3) {

        if (pos1 == str1.length && pos2 == str2.length && pos3 == str3.length )

            return  true;

        if (pos3 == str3.length)
            return  false;

        return (pos1 < str1.length && str1[pos1] == str3[pos3] && isInterleavedRec(str1, str2, str3, pos1+1, pos2, pos3+1)) ||
                (pos2 < str2.length && str2[pos2] == str3[pos3] && isInterleavedRec(str1,str2,str3, pos1, pos2+1, pos3+1));
    }
    public static void main(String args[]){
        StringInterleaving sti = new StringInterleaving();

        String str1 = "XXYM";
        String str2 = "XXZT";
        String str3 = "XXXZXYTM";
  //      System.out.println(sti.isInterleaved(str1.toCharArray(), str2.toCharArray(), str3.toCharArray()));

         str1 = "aab";
         str2 = "axy";
         str3 = "aaxaby";
        System.out.println(sti.isInterleaved(str1.toCharArray(), str2.toCharArray(), str3.toCharArray()));

    }

}
