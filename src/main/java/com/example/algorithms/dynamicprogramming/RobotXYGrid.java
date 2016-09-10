package com.example.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by chirag on 9/5/16.
 */
public class RobotXYGrid {

    public boolean getPath (int x, int y, int x1, int y1, ArrayList<Point> path) {
      Point point = new Point(x,y);
      path.add(point);

        System.out.println(x + ":" + y);
        if (x == x1 && y == y1)
            return  true;

        boolean success = false;

        if (x < x1 && isFree(x+1,y, path)) {
            success = getPath(x+1, y, x1, y1,path);
        }

        if (success) {
//            System.out.println("Success " + point.x +"," + point.y);
                path.add(point);
            for (Point p : path) {
                System.out.println("Path (" + p.x + "," + p.y + ")");
            }
            path.clear();
  //              return success;
        }


        if ( y < y1  && isFree(x, y+1, path)) {
            success = getPath(x, y+1, x1,y1,path);
        }

        if (success) {
            path.add(point);
            //            System.out.println("Success " + point.x +"," + point.y);
            for (Point p : path) {
                System.out.println("Path (" + p.x + "," + p.y + ")");
            }

            path.clear();
        }

        return success;

    }

    public boolean isFree(int x, int y, ArrayList<Point> pointArrayList) {
        for (Point p : pointArrayList) {
            if (p.x == x && p.y == y)
                return false;
        }

        return  true;
    }


    class Point {
        int x,y;
        public  Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean getPath(int x, int y, ArrayList<Point> pointArrayList, HashMap<Point, Boolean> cache) {
        Point p = new Point(x,y);

        if (cache.containsKey(p)) {
            return  cache.get(p);
        }

        if (x ==0 && y == 0)
            return  true;

        boolean success = false;

        if (x >=1 && isFree(x-1, y, pointArrayList)) {
            success = getPath(x-1,y, pointArrayList, cache);
        }

        if (!success && y >=1 && isFree(x,y-1, pointArrayList)) {
            success = getPath(x, y-1, pointArrayList, cache);
        }

        if (success) {
            pointArrayList.add(p);
        }
        cache.put(p, success);
        return  success;
    }

    public static void main(String args[]){
        int x = 2;
        int y = 2;
        ArrayList<Point> path = new ArrayList<Point>();

        RobotXYGrid robotXYGrid = new RobotXYGrid();
        robotXYGrid.getPath(0,0,x,y, path);

        for (Point p : path) {
//            System.out.println("Path (" + p.x + "," + p.y + ")");
        }

        path.clear();
        HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();

        robotXYGrid.getPath(x,y, path,cache);

        for (Point p : path) {
            System.out.println("Path with DP (" + p.x + "," + p.y + ")");
        }

    }
}
