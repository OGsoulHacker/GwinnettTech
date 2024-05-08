package hello;
import java.util.Scanner;
/*Enable GeometricObject
  Modify the GeometricObject class to:
    - implement the Comparable interface.
    - Define a static max method in the GeometricObject class
      for finding the larger of the 2 GeometricObject objects.
  Write a test program that uses the max method to find the
  larger of the two circles, the larger of two rectangles
*/
/*
public class Lab04_13_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Create an object for circle1
        GeometricObjects firstCircle = new GeometricObjects(15, 23,6, "circle 1"); //----For your circles, the breadth and length should be 0

        //Create an object for circle2
        GeometricObjects secondCircle = new GeometricObjects(8, -1, 2, "circle 2"); //----same as above

        //Create an object for rectangle1
        GeometricObjects firstRectangle = new GeometricObjects(10, 20, 15, "rectangle 1"); //----For your rectangles, the radius should be 0

        //Create an object for rectangle2
        GeometricObjects secondRectangle = new GeometricObjects(20, 15, 30, "rectangle 2");  //----same as above

        //call max method
        GeometricObjects.max(firstCircle, secondCircle);

        //call max method
        GeometricObjects.max(firstRectangle, secondRectangle);
    }
}
//Implementation of GeometricObject class
public class GeometricObjects implements Comparable {
    //Declare radius , breadth,length as type of integer
    int radius, breadth, length;
    String shapeFormat;
    double area;
    //Implement parameterized constructor
    public GeometricObjects(int radius, int b, int l, String shape) {
        super();

        this.radius = radius;
//measure or dimension from side to side
        this.breadth = b;
        this.length = l;
        this.shapeFormat = shape;
//check radius is greater than 0
        if (radius > 0) {
//calculate the area of circle
            area = Math.PI * radius * radius;
        } else {
//calculate the rectangle ares
            area = breadth * length;
        }
    }
    //Implementation of max method
    //Using object type GeometricObjects
    public static void max(GeometricObjects object1, GeometricObjects object2) {
//check whether object1.compareTo(object2) is
//greater than 0 or not
        if (object1.compareTo(object2) > 0) {

//Display statement
            System.out.println(object1.shapeFormat + " is larger than " + object2.shapeFormat);
        }
//check whether object1.compareTo(object2) is
//less than 0 or not
        else if (object1.compareTo(object2) < 0) {
//Display statement
            System.out.println(object2.shapeFormat + " is larger than " + object1.shapeFormat);
        } else {
//Display statement
            System.out.println(object1.shapeFormat + " is equal to " + object1.shapeFormat);
        }
    }
    @Override
//Implementation of compareTo method
    public int compareTo(Object requiredObject) {
//check whether this.area is greater than the
//(GeometricObject)requiredObject).area or not
        if (this.area > ((GeometricObjects) requiredObject).area) {
            return 1;
        }
        //check whether this.area is less than the
        //(GeometricObject)requiredObject).area or not
        else if (this.area < ((GeometricObjects) requiredObject).area) {
            return -1;
        } else {
            return 0;
        }
    }
}
*/
