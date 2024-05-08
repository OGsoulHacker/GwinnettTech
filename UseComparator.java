package hello;
import java.awt.geom.*;
import java.awt.*;
import java.util.Comparator;
/*Use Comparator
    > Write the following generic method using selection
      sort and a comparator.
        * public static <E> void selectionSort(E[] list,
            Comparator<? super E> comparator)
    > Write a test program that creates an array of 10
      GeometricObjects and invokes this method using the
      GeometricComparator introduced in listing 20.5 to
      sort the elements.
    > Display the sorted elements
    > Use the following statement to create the array:
        * GeometricObject[] list1 = {new Circle(5), new Rectangle(4,5),
          new Circle(5,5), new Rectangle(2.4,5), new Circle(0.5),
          new Rectangle(4,65), new Circle(4.5), new Rectangle(4.4,1),
          new Circle(6.5), new Rectangle(4,5)};
   > Also in the same program, write the code that sorts six strings
     by their last character. Use the following to create the array:
        * String[] list2 = {"Red", "Blue", "Green", "Yellow", "Orange",
          "Pink"}
*/

public class UseComparator
//Listing 20.5 GeometricObjectComparator
    implements Comparator<GeometricObject>, java.io.Serializable {//Implements comparator
    //Start of main method
    public static void main(String[] args) {

        //Geometric object array
        GeometricObject[] list1 = {new Circle(5), new Rectangle(4, 5),
                new Circle(5, 5), new Rectangle(2.4, 5), new Circle(0.5),
                new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};
        //Array of 6 strings
        String[] list2 = {"Red", "Blue", "Green", "Yellow", "Orange",
                "Pink"};

        System.out.println("Before sort:");
        for (GeometricObject o : list) {
            System.out.println(o.getArea());
        }
        System.out.println("After sort");
        for (GeometricObject o : list) {
            System.out.println(o.getArea());
        }

    }//End of main method
    //Listing 20.5 GeometricObjectComparator
    public int compare(GeometricObject o1, GeometricObject o2) {//Implements compare
        double area1 = o1.getArea();
        double area2 = o2.getArea();

        if (area1 < area2)
            return -1;
        else if (area1 == area2)
            return 0;
        else return 1;
    }//Listing from 20.5 ends here

    //generic method using selection sort and a comparator
    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {

            E currentMin = list[i];
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (comparator.compare(list[j], currentMin) < 0) {
                    currentMin = list[j];
                    minIndex = j;
                }
            }
            //if minIndex is not equal to
            if (minIndex != i) {
                list[minIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}

