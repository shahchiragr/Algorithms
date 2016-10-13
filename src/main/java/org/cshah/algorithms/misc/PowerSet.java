package org.cshah.algorithms.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cshah on 5/7/14.
 *
 * We are given a set of integers with repeated occurences of elements. For Example, S={1,2,2}.
 We need to print the power set of S ensuring that the repeated elements of the power set are printed only once.
 For the above S, the power set will be {NULL, {1}, {2}, {2}, {1,2}, {1,2}, {2,2}, {1,2,2}}.
 So, as per the question requirements, we need to print {NULL, {1}, {2}, {1,2}, {2,2}, {1,2,2}}
 */
public class PowerSet {

    public static void main(String[] args) {
        String s = "abxa";
        PowerSet ps = new PowerSet();
        System.out.println("Is Pelimdrome :" + ps.isKPalindromeRec(s.toCharArray(), 1, 0, s.length()-1));
        s = "abdxa";
        System.out.println("Is Pelimdrome :" + ps.isKPalindromeRec(s.toCharArray(), 1, 0, s.length()-1));

    }
    public static void powerset(){
        int a[]={1,2,2};
        int n=a.length;
        int cf=(int)Math.pow(2,n);
        List<String> l=new ArrayList<String>();
        for(int c=0;c<cf;c++){
            String s="";
            for(int j=0;j<n;j++){
                int x=c&(1<<j);
                System.out.println("HERE " + c + ":" + j + " : " + x);

                if(x!=0){
                    s+=a[j];

                }
            }
            if(!l.contains(s)){
                l.add(s);
            }
        }
        for(String st:l){
            System.out.println(st);
        }

    }


    boolean isKPalindromeRec(char[] arr, int k, int left, int right){

        if( left >= right ){
            return k >= 0;
        }

        if( arr[left] == arr[right] ){
            return isKPalindromeRec(arr, k, left+1, right-1);
        }

        return isKPalindromeRec(arr, k-1, left+1, right) || isKPalindromeRec(arr, k-1, left, right-1);
    }
}
