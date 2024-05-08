package hello;
import java.util.Scanner;
/*Triangle class:
Design a new Triangle class that extends the abstract GeometricObject class.
Write a test program that prompts the user to enter:
    - 3 sides of the triangle
    - a color
    - a boolean value to indicate whether the triangle is filled
The program should use input to:
    - create a Triangle object with 3 sides
    - set the color properties
    - set the filled properties
Program should display:
    - the area
    - perimeter
    - color
    - true or false to indicate whether it's filled or not
*/
public class Lab04_13_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        double side1, side2, side3;
        boolean filled;

        System.out.println("Enter three sides: ");
        side1 = input.nextDouble();
        side2 = input.nextDouble();
        side3 = input.nextDouble();
        System.out.println("Enter the color: ");
        String color;
        color = input.next();
        System.out.println("Enter true/false for filled : ");
        filled = input.nextBoolean();
        Triangle triangle = new Triangle(side1, side2, side3, color, filled);

        triangle.setColor(color); //----Don't need this, the color will get set as part of the constructor on line 35
        triangle.setFilled(filled); //----same as above

        System.out.println("Area is "+triangle.getArea());
        System.out.println("Perimeter is "+triangle.getPerimeter());
        System.out.println("Color is " +triangle.getColor());
        System.out.println("Filled is "+(triangle.isFilled()));
    }
}
//Triangle class is child class of GeometricObject
class Triangle extends GeometricObject{
    Scanner input = new Scanner(System.in);
    private double side1;
    private double side2;
    private double side3;
    double area;
    double perimeter;
    double height;
    Triangle()
    {
        setSide1(1.0);
        setSide2(1.0);
        setSide3(1.0);
    }
    Triangle(double s1,double s2,double s3, String color, boolean filled)
    {
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);
        setColor(color);
        setFilled(filled);

    }
    @Override
    public double getArea() {
        perimeter = getPerimeter()/2;
        height = perimeter * (perimeter - side1) * (perimeter - side2) * (perimeter-side3);
        area = Math.sqrt(height);
        return (area);
    }

    @Override
    public double getPerimeter() {
        side1 = getSide1();
        side2 = getSide2();
        side3 = getSide3();
        return (side1+side2+side3);
    }
    public double getSide1(){
        return side1;
    }
    public double getSide2(){
        return side2;
    }
    public double getSide3(){
        return side3;
    }
    void setSide1(double side1) {
        side1 = this.side1;
    }
    void setSide2(double side2) {
        side2 = this.side2;
    }
    void setSide3(double side3) {
        side3 = this.side3;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

