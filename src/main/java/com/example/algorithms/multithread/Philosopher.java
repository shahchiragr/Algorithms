package com.example.algorithms.multithread;

import javafx.scene.paint.PhongMaterial;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cshah on 5/11/14.
 */
public class Philosopher extends  Thread {
    private int bites = 10;
    private ChopStick left;
    private ChopStick right;
    private int id;

    class ChopStick {
        private Lock lock = new ReentrantLock();

        public boolean pickUp() {
            try {
                return lock.tryLock(100L, TimeUnit.MILLISECONDS);
//            return lock.tryLock(1000);
            }catch (Exception e) {}

            return false;
        }

        public void putDown() {
            lock.unlock();
        }
    }

    public Philosopher() {

    }
    public Philosopher(int id,ChopStick left, ChopStick right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    public boolean eat() {
        if ( pickUp()) {
            chew();
            putDown();
        } else {
            return false;
        }
        return  true;
    }

    private boolean pickUp() {
        if ( !left.pickUp())
            return false;

        if (!right.pickUp()) {
            left.putDown();
            return false;
        }

        return true;
    }

    private void chew() {
        try {
            System.out.println("Philosopher " + id + " is eating...");
            Thread.sleep(100);
        }catch (Exception exp) {}
    }

    private void putDown() {
        left.putDown();
        right.putDown();
    }

    public void run() {
        for (int i=0; i<bites;i++) {
            if (!eat()) {
                i--;
            }
        }
    }

    public void DiningPhilosopher (int num) {

        ChopStick forks[] = new ChopStick[num];
        Philosopher array[] = new Philosopher[num];


        for (int i=0; i < num; i++) {
            forks[i] = new ChopStick();
        }

        for (int i=0; i < num; ++i)  {
            int fork1 = i;
            int fork2 = (i+1) % num;

            array[i] = new Philosopher(i, forks[i], forks[(i+1) % num]);
            if (i==0) {
                System.out.println(fork2 + ":" + fork1);
            } else {
                System.out.println(fork1 + ":" + fork2);
            }
        }


        for (int i=0; i < num; ++i) {
            array[i].start();
        }

//        for (int i=0; i < num; ++i) {
//            try {
//                array[i].join();
//            }catch (Exception e){}
//        }

    }

    public  static void  main(String args[]) {
            Philosopher p = new Philosopher();
            p.DiningPhilosopher(6);
            try {
                 Thread.sleep(30000);
            } catch (Exception e) {}
    }
}
