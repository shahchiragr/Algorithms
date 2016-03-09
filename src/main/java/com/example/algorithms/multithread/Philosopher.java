package com.example.algorithms.multithread;

/**
 * Created by cshah on 5/11/14.
 */
public class Philosopher {

    public void DiningPhilosopher (int num) {
        Object forks[] = new Object[num];
        for (int i=0; i < num; ++i)  {
            int fork1 = i;
            int fork2 = (i+1) % num;

            if (i==0) {
                System.out.println(fork2 + ":" + fork1);
            } else {
                System.out.println(fork1 + ":" + fork2);
            }
        }
    }

    public  static void  main(String args[]) {
        Philosopher p = new Philosopher();
        p.DiningPhilosopher(6);
    }
}
