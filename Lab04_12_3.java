package hello;
import java.util.Arrays;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;
/* 12.3: ArrayIndexOutOfBoundsException
    Write a program that meets the following requirements:
        - Creates an array with 100 randomly chosen integers
        - Prompts the user to enter the index of the array, then displays the corresponding element value.
          If the specified index is out of bounds, display the message "Out of Bounds".
*/
public class Lab04_12_3 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        // Generate an Array of 100 integers
        int[] myArray = new int[100];
            for(int i = 0; i < myArray.length; i++)
            {
                myArray[i] = (int)(Math.random() * 100);//Creates an array with 100 randomly chosen integers
            }
        System.out.println("Elements in the array are: ");
        System.out.println(Arrays.toString(myArray));

        System.out.println("Enter the index of the required element: ");
        int element = input.nextInt();
    // Validate the index and if found valid then print the associate index item else print "Out of Bounds"
        try{
            System.out.println("Element in the given index is : "+ myArray[element]); //The line(s) of code that you suspect could trigger the exception goes inside the 'try' block. (in this case, the statement 'myArray[element]' will trigger one if element is ever greater than 100)
        }
        catch(ArrayIndexOutOfBoundsException ex){ //Here you specify the type of exception you think could happen as a variable. (in this case, we think an ArrayIndexOutOfBoundsException exception could happen).
            System.out.println("Out of Bounds"); //What to do if an exception is caught
        }
    }
}
