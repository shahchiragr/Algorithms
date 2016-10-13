package org.cshah.algorithms.string;


public class AllUniqueChar {

    public static boolean isAllUniqueChar(String str) {

        int checker = 0;
        for (int i=0; i<str.length(); i++) {
            int val = str.charAt(i) - 'a';
            System.out.println("VAL " + val + ": & Checker : " + (checker & ( 1 << val)) + " :" +  checker + ":" + ( ( 1 << val)) );
            if ((checker & ( 1 << val)) > 0)
                return false;
            checker = checker | ( 1<< val);
            System.out.println("New Checker : " + checker);
        }
        return true;
    }

    public static boolean isAllUniqueChar2(String str) {

        boolean char_set[] = new boolean[256];
        for (int i=0; i<str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;

            char_set[val] = true;
        }
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long stime = System.nanoTime();
        System.out.println( AllUniqueChar.isAllUniqueChar("abcdefghijklmnopqrstuvwxyz"));
        System.out.println( AllUniqueChar.isAllUniqueChar("abcdefghijklmnopqrstuvwxyza"));
        long etime = System.nanoTime();
        System.out.println("ALGO 1 : " + (etime - stime));

        stime = System.nanoTime();
        System.out.println( AllUniqueChar.isAllUniqueChar2("abcdefghijklmnopqrstuvwxyz"));
        System.out.println( AllUniqueChar.isAllUniqueChar2("abcdefghijklmnopqrstuvwxyza"));
        etime = System.nanoTime();
        System.out.println("ALGO 2 : " + (etime - stime));

    }

}