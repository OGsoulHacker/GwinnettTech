import java.util.Scanner;

import static java.lang.Math.exp;

public class J1_Lab04_2 {
    public static void main (String[] args){
            Scanner input = new Scanner(System.in);
        System.out.println("======================================================================");
        System.out.println("Trigonometric (9)");
        System.out.println("======================================================================");
            System.out.println("1:Math.PI");
                int r = 5;
                double area = Math.PI*(r*r);
                double cir = 2*(Math.PI*r);
                System.out.println("Radius of circle " + r);
                System.out.println("Area of circle is " + area);
                System.out.println("Circumference of circle is "+cir);
            System.out.println("Math.E");
                System.out.println("Exponential constant is " + Math.E);
            System.out.println("sin()");
                double anyNumber = Math.sin(5);
                System.out.println("Trigonometric Sine value of 5 is " +" "+ anyNumber);
            System.out.println("Math.cos()");
                double x = 60;
                double y = Math.toRadians(x);
                System.out.println("Trigonometric Cosine value 60 is "+ " " + Math.cos(y));
            System.out.println("Math.tan()");
                 double a = 60;
                 double b = Math.toRadians(a);
                 System.out.println("trigonometric Tangent value of 60 is " + Math.toRadians(b));
            System.out.println("Math.acos()");
                double c = -1.0;
                System.out.println("Trigonometric Arc Cosine value 1.0 is " + Math.acos(c));
            System.out.println("Math.asin()");
                double d = 1.0;
        System.out.println("Trigonometric Arc Sine value of 1.0 is " + Math.acos(d));
            System.out.println("Math.atan()");
                double e = -9.0;
                System.out.println("Trigonometric Arc Tangent value of -9 is " + Math.atan(e));
            System.out.println("Math.toRadians()");
                double x1 = Math.toDegrees(1.45);
                double x2 = Math.toDegrees(0.78);
                double x3 = Math.toDegrees(0.0);

                double y1 = Math.toRadians(90);
                double y2 = Math.toRadians(45);
                double y3 = Math.toRadians(0);
                    Math.cos(45);
                    Math.atan(45);
                //Prints out Degrees
                    System.out.println("The degrees for X are.");
                        System.out.println("X1:"+ x1);
                        System.out.println("X2:"+ x2);
                        System.out.println("X3:"+ x3);
                //Prints out Radians
                    System.out.println("The radians for Y are.");
                        System.out.println("Y1:"+ y1);
                        System.out.println("Y2:"+ y2);
                        System.out.println("Y3:"+ y3);
        System.out.println("======================================================================");
        System.out.println("Exponent (5)");
        System.out.println("======================================================================");
            System.out.println("exp()");
                double f = 0.0;
                System.out.print("Argument of 0 will return " + Math.exp(f));
            System.out.println("log()");
                double g = 22.0;
                System.out.println("The natural logarithm of 22 is " + Math.log(g));
            System.out.println("log10()");
                double h = 22.0;
                System.out.println("The base 10 logarithm of 22 is " + Math.log10(h));
            System.out.println("pow()");
                double j = 7.0;
                double k = 3.0;
                System.out.println("The value of first argument raised to the power to second argument is " + Math.pow(j,k));
            System.out.println("sqrt()");
                double l = 18.0;
                System.out.println(" the square root of 18 is " + Math.sqrt(l));
            System.out.println("Exp()");
                double m = 2.0;
                System.out.println(Math.exp(m));
        System.out.println("======================================================================");
        System.out.println("Rounding (9)");
        System.out.println("======================================================================");
            System.out.println("ciel()");
                double n = -94.73;
                // Input negative value, Output ceil value of x
             System.out.println(Math.ceil(n));
            System.out.println("floor()");
                double o = 94.69;
                // Input positive value, Output floor
            System.out.println(Math.floor(o));
            System.out.println("Math.rint()");
                double p = 80.5;
                double q = 79.5;
                    System.out.println("Rounds upto 80 which is the nearest even double value");
                    System.out.println(Math.rint(p));
                    System.out.println(Math.rint(q));
            System.out.println("int round()");
            System.out.println("long round()");
                double r2 = 100.675;
                double s = 100.500;
                float t = 100;
                float u = 90f;
                    System.out.println("Long rounded from 100.657 is " + Math.round(r2));
                    System.out.println("Long rounded from 100.500 is " + Math.round(s));
                    System.out.println("Int rounded from 100 is " + Math.round(t));
                    System.out.println("Int rounded from 90 is " + Math.round(u));
            System.out.println("max");
                int v = 20;
                int w = 50;
        //print the maximum of two numbers
                System.out.println("maximum of two numbers " + Math.max(v, w));
            System.out.println("min");
                int x4 = 20;
                int y4 = 50;
        //print the minimum of two numbers
        System.out.println("The Smallest of two numbers" + Math.min(x4,y4));
            System.out.println("abs");
                int x5 = 78;
                int y5 = -48;
        //print the absolute value of int type
                    System.out.println(Math.abs(x5));
                    System.out.println(Math.abs(y5));
                    System.out.println("absolute value is" + Math.abs(Integer.MIN_VALUE));
        //System.out.println(random);
        // Generate random number between 0 to 20
                double a2 = Math.random() * 20;
                double b2 = Math.random() * 20;
        // Output is different every time this code is executed
                    System.out.println("Random number between 0-20: " + (a2));
                    System.out.println("Random number between 0-20: " + (b2));
    }
}
