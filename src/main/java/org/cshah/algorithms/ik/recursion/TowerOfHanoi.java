package org.cshah.algorithms.ik.recursion;

public class TowerOfHanoi {

    public void towerOfHanoi(int n, char source, char dest, char aux) {
            if (n == 1) {
                System.out.println("Disk moved from " + source + " to  " + dest + " : " + n);
                return;
            }

        towerOfHanoi(n-1, source, aux, dest);
        System.out.println("Disk moved from " + source + " to  " + dest + " : " + n);
        towerOfHanoi(n-1, aux, dest,source);
    }

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        int n = 4;
        towerOfHanoi.towerOfHanoi(n, 'a', 'b', 'c');
    }
}
