package hello;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/*Process scores in a text file
Suppose a text file contains an unspecified number of scores separated by spaces.
Write a program that prompts the user to enter the file, reads the scores from the file, and displays
their total average.
 */
public class Lab12_14 {
    public static void main(String[] args) {
        int countScores = 0; // Counts scores
        double total = 0; // Accumulates total
        //Creating Scanner class reference
        Scanner input = new Scanner(System.in);
        String fileName;

            System.out.print("Enter the input filename :");
            fileName = input.nextLine();
            //Opening file
            input = new Scanner(new File(String.valueOf(fileName)));
            // Check if file exists
            if (!fileName.exists()) {
                System.out.println("File " + fileName + " does not exist");
                System.exit(1);
            }
        try (
        // Create input file
                Scanner inputFile = new Scanner(fileName);
        ) {
            while (inputFile.hasNext()) {
                total += inputFile.nextInt();
                countScores++;
            }
        }
        // Display results
        System.out.println("Total is: " + total);
        System.out.println("Average is : " + (total / countScores));

        }
    }
