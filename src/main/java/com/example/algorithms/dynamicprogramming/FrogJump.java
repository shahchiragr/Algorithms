package com.example.algorithms.dynamicprogramming;

/**
 * Created by chirag on 9/14/16.
 */

import java.io.*;
import java.util.*;

public class FrogJump {


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.

  A frog needs to cross the river, and the cross section of the river is represented in
  the format of x's and -'s.
  x = land
  - = water

 ->terrain: "xx--xxx-x-x"

 -> assume terrain[0] = "x" and terrain[terrain.length-1] = "x".

 -> For the first jump - the frog has a speed of 1 step.

 -> For the any of the steps that follow, the frog can increase it's speed by
   +1 step , or decrease by -1 step or continue at the same speed.

   eg. if the frog is at terrain[i] and it reached there with velocity - 'v',
   in the next jump  next velocity can be - {  v+1, v, v-1 }

 -> If the frog can reach the last position or jump over the last position -
  you can return true.



  implement a method called -
  boolean canFrogCross(String terrain)


  examples:

  canFrogCross("xx") -> returns true
  canFrogCross("xx-x") -> true
  canFrogCross("xx--x") -> false



 *
 * If you need more classes, simply define them inline.
 */

        public static boolean canReachToLand(String terrain, int length, int velocity, int currentIndex) {
            int cIndex = currentIndex+velocity;

            if (terrain == null || terrain.isEmpty() || cIndex > length || velocity <= 0) {
                return false;
            }

            if (terrain.length()-1 == currentIndex+velocity) {
                return true;
            }

            if (terrain.charAt(cIndex) == '-') {
                return false;
            }

            boolean bval = canReachToLand(terrain, length, velocity, cIndex)
                    ||   canReachToLand(terrain, length, velocity+1, cIndex)
                    ||   canReachToLand(terrain, length, velocity-1, cIndex);


            return bval;


        }

        public static void main(String[] args) {
            String [] sArray = {"xx--xxx-x-x","xx","xx-x", "xx--x"};
            for (String terrain : sArray) {
                int velocity = 1;
                boolean bval = FrogJump.canReachToLand(terrain, terrain.length(), velocity, 0);
                System.out.println("For "  +terrain + " path, Frog can reach to land " + bval);
            }
        }

}
