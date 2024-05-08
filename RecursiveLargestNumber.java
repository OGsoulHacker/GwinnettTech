package hello;
import java.util.Scanner;
/*Find the largest number in an array
    > Write a recursive method that returns the largest integer
    in an array
    >Write a test program that prompts the user to enter a list
     of eight integers and display the largest element
*/
public class RecursiveLargestNumber {
    /**
     * The Class FindLargest.
     */
    public class FindLargest {

        /**
         * The main method.
         */
        public static void main(String[] args) {

            // Scanner object to input from user
            Scanner scan = new Scanner(System.in);
            // prompt for the number of element
            System.out.print("Enter the number of elements for the array: ");
            int n = scan.nextInt();// read input
            // create array
            int[] array = new int[n];
            // prompt to enter the elements
            System.out.print("Enter " + n + " elements: ");
            // read elements and save into array
            for (int i = 0; i < array.length; i++) {
                array[i] = scan.nextInt();
            }

            System.out.println("The largest number in the array is: " + largestNumber(array));
            scan.close();

        }

        /**
         * Gets the largest.
         */
        public static int largestNumber(int[] arr) {

            return largestNumber(arr, 0, arr[0]); // start from 0
        }

        /**
         * Gets the largest.
         */
        public static int largestNumber(int[] arr, int i, int high) {

            // if i is equal to array length
            if (i == arr.length)
                return high;// return the current high

            // if high is less than current array element
            if (high < arr[i])
                high = arr[i];// change high with current array element
            return largestNumber(arr, i + 1, high); // increase the i and call this method recursively
        }

    }
}