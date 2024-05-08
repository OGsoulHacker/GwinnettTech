package hello;
import java.util.Scanner;
/*Part1 10.13:Define the MyRectangle2D class that contains:
            - 2 double data fields named x and y that specify the center of the rectangle with getter and
              setter methods. (Assume the rectangle sides are parallel x - or y - axis)
            - data fields width and height with getter and setter methods
            - a no- arg constructor that creates a default rectangle with (0. 0) for (x, y) and 1 for both
              width and height.
            - A constructor that creates a rectangle with the specified x, y, width, and height
            - A method getArea() that returns the area of a rectangle
            - A method getPerimeter() that returns the perimeter of the rectangle
            - A method contains (double x, double y) that returns true if the specified point (x, y) is inside the
              rectangle
            - A method contains(MyRectangle2D r) that returns true if the specified rectangle is inside the rectangle
            - A method overlaps(MyRectangle2D r) that returns true if the specified rectangle overlaps with this
              rectangle.

   Part2 10.15:Write a method that returns a bounding rectangle for a set of points in a two-dimensional plane
         as follows:
                    - public static MyRectangle2D getRectangle(double [] [] points)
              The Rectangle2D class is defined in programming exercise 10.13. Write a test program that prompts the user
              to enter 5 points and displays the bounding rectangle's center, width, and height
 */
public class BoundingRectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // The following method is just to test the program. Please remove if
        // unnecessary
        double[][] points = new double[5][2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter five points: ");
        for (int i = 0; i < 5; i++) {
            points[i][0] = sc.nextDouble();
            points[i][1] = sc.nextDouble();
        }

        MyRectangle2D rect = MyRectangle2D.getRectangle(points);
        System.out.println("The Bounding Rectangle's center is (" + rect.getX()
                + ", " + rect.getY() + "), width " + rect.getWidth()
                + ", height " + rect.getHeight());


        //Example to test first contains method
        /*
        MyRectangle2D rect1 = new MyRectangle2D(0,0,6,6);
        System.out.println("Original rectangle's center is (" + rect1.getX()
                + ", " + rect1.getY() + "), width: " + rect1.getWidth()
                + ", height: " + rect1.getHeight());
        System.out.println("Enter x and y for first contains method: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.println("Point (" + x1 + "," + y1 + ") is inside the original rectangle: " + rect1.contains(x1,y1));
        */


        //Example to test second contains method
        /*
        MyRectangle2D rect2 = new MyRectangle2D(0,0,8,8);
        System.out.println("Original rectangle's center is (" + rect2.getX()
                + ", " + rect2.getY() + "), width: " + rect2.getWidth()
                + ", height: " + rect2.getHeight());
        System.out.println("Enter x, y, width, and height for second contains method: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double width2 = input.nextDouble();
        double height2 = input.nextDouble();
        MyRectangle2D userRect = new MyRectangle2D(x2,y2,width2,height2);
        System.out.println("User's rectangle is inside the original rectangle: " + rect2.contains(userRect));
        */
    }
}
class MyRectangle2D {
    double height;
    double width;
    double x;
    double y;

    public MyRectangle2D()// No-arg constructor that sets length, width, x and y
    {
        height = 1;
        width = 1;
        x = 0;
        y = 0;
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    //Getter methods
    public double getX()//getter method gets x and returns x
    {
        return x;
    }

    public double getY()//getter method gets y and returns y
    {
        return y;
    }

    public double getHeight()//getter method gets length and returns length
    {
        return height;
    }

    public double getWidth()//getter method gets width and returns width
    {
        return width;
    }

    //Setter methods
    public void setX() {
        this.x = x;
    }

    public void setY() {
        this.y = y;
    }

    public void setWidth() {
        this.width = width;
    }

    public void setHeight() {
        this.height = height;
    }

    double getArea()//getter method gets area and returns area
    {
        double area = this.width * this.height;
        return area;
    }

    double getPerimeter()//getter method gets perimeter and returns perimeter
    {
        double perimeter = 2 * (this.width + this.height);
        return perimeter;
    }

    //Method contains(double x, double y) returns true if the specified point (x, y) is inside this rectangle
    public boolean contains(double x, double y) {
        return (2 * Math.abs((x - this.x)) < width && 2 * Math.abs((y - this.y)) < height);
    }

    //Method contains(MyRectang2D r) returns true if the specified rectangle is inside this rectangle
    public boolean contains(MyRectangle2D r) {
        return (2 * Math.abs((r.getX() - this.x)) < width && 2 * Math.abs((r.getY() - this.y)) < height); //----Similarly not sure about this equation....
        //however, along with the notes I listed for the other contains() method, I'm pretty sure you should also to be referencing r.getWidth() and r.getHeight() at some point.
    }

    //method overlaps(MyRectangle2D r1) returns true if the specified rectangle overlaps with this rectangle.
    public boolean overlaps(MyRectangle2D r) {
        return (contains(r.getX(), r.getY()) || contains(r.getX() + r.getWidth(),
                r.getY()) || contains(r.getX(), r.getY() + r.getHeight()) || contains(r.getX() + r.getWidth(),
                r.getY() + r.getHeight())) && !contains(r);//----This one I'm not sure about overall
    }

    public static MyRectangle2D getRectangle(double[][] points) {
// get Minimum, Maximum X of given points
        double minX = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        for (int i = 0; i < 5; i++) {
            if (points[i][0] < minX)
                minX = points[i][0];
            if (points[i][0] > maxX)
                maxX = points[i][0];
        }
// get Minimum, Maximum Y of given points
        double MaxY = Double.MIN_VALUE;
        double MinY = Double.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            if (points[i][1] > MaxY)
                MaxY = points[i][1];

            if (points[i][1] < MinY)
                MinY = points[i][1];
        }
// width of rectangle is max x- min x
        double width = Math.abs(maxX - minX); //----width is always a positive number, so this should be Absolute Value of maxX - minX

// height of rectangle is max y - min y
        double height = Math.abs(MaxY - MinY); //----height is always a positive number, so this should be Absolute Value of maxY - minY

// calculate center x and center y
        double centerX = (minX + maxX) / 2.0;
        double centerY = (MinY + MaxY) / 2.0;
        MyRectangle2D rect = new MyRectangle2D(centerX, centerY, width, height);
        return rect;
    }
}
