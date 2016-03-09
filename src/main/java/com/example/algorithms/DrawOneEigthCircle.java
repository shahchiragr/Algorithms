package com.example.algorithms;

/**
 * Created by cshah on 4/27/14.
 */
public class DrawOneEigthCircle {


    public static void drawEigthhOfCircle(int radius) {
        double x,y;
        x=0;
        y= radius;

        while (y > x) {
            y = (double)(Math.sqrt( (radius * radius) - ( x * x)));
            System.out.println("Pixel x(" + x + ") :y(" + y + ")");
            x++;
        }
    }
    public static  void  main(String args[]) {
        DrawOneEigthCircle.drawEigthhOfCircle(5);

    }

}
