package hello;
import java.util.Scanner;
/*Geometric Linear Search
    > Implement the following generic method for linear search
        public static <E extends comparable<E>>
           int linearSearch(E[] list, E key)
*/
public class GeometricLinearSearch {
    public static void main(String[] args) {
        String[] strings = new String[]{"Alex", "Misa", "Ben", "Callie","Kaizu"};
        String[] strings2 = new String[]{"Kaizu", "Callie", "Ben", "Misa","Alex"};
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5,2};
        Double[] dbl= new Double[] {1.2,3.6,8.4,8.4,8.4,3.6};
        GeometricLinearSearch array = new GeometricLinearSearch();
        array.linearSearch(strings, "Bob");
        array.linearSearch(strings, "Tim");
        array.linearSearch(ints, 2);
        array.linearSearch(dbl, 8.4);
    }
    //Generic method for linear search
    public static <E extends Comparable <E>>
    int linearSearch(E[] list, E key){
            int count = 0;//Count initialized to zero
            //Linear searching array
            for (int i = 0; i < list.length; i++)
            {
                if (list[i].equals(key))
                {
                    count++;
                }
            }
            System.out.println("There is a element " + key +
                    " repeated " + count + " time(s)");
            return count;
        }
}
