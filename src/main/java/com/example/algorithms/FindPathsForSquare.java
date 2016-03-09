package com.example.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cshah on 4/30/14.
 */
public class FindPathsForSquare {

    List<Point> pathList = new ArrayList<Point>();

    public boolean getPaths(int x, int y) {
        boolean success = false;
        Point p = new Point(x,y);
        pathList.add(p);

        if (x== 0 && y ==0) return true; //current path

        if (x >=1 && is_free(x-1, y)) {       //Try right
            success = getPaths(x-1,y);
        }

        if (!success && y >= 1 && is_free(x, y-1)) { //try left
            success = getPaths(x, y-1);

         }

        if (!success) {
            pathList.remove(p);
        }  else {
            System.out.println("Path worked " + p.getX() + ":" + p.getY() );
        }
        return  success;
    }

    public boolean is_free(int x, int y) {
        //return ( x > 0 && y > 0)  ;
        return !pathList.contains(new Point(x,y));
    }

    class Point {
        int x;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            if (y != point.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static  void main(String args[]) {
        FindPathsForSquare obj = new FindPathsForSquare();
        obj.getPaths(2,2);
    }
}

