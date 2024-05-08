package hello;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/*(Count characters, words, and lines in a file)
Write a program that will count the number of characters, words, and lines in a file.
words are separated by whitespace characters.
The file name should be passed as a command line argument.

 */
public class Lab12_13 {
    public static void main(String[] args) {
        //Creating Scanner class reference
        Scanner input = new Scanner(System.in);
        //Declaring variables
        int countLines = 0;
        int countWords = 0;
        int countCharacters = 0;
        String line = null;
        String fileName;
        String words[];

        try {
            System.out.print("Enter the input filename :");
            fileName = input.nextLine();
            //Opening file
     //       input = new Scanner(new file(fileName));

            //The loop continues to execute until the end of the file
            while(input.hasNext()){
                //Counting the number of lines
                countLines++;
                line = input.nextLine();
                //The for loop will count number of characters in the file
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) != ' ' && line.charAt(i) != '\n' ){
                        //Counting number of characters
                        countCharacters++;
                    }
                }
                //Splitting each line into a String array
                words = line.split(" ");
                for (int j = 0; j < words.length; j++){
                    //Counting number of words in the file
                    countWords++;
                }
            }
        }catch (IOException e) {
            //Display the exception
            System.out.println("Exception: " + e);
        }
        //Displaying the number of lines in the file
        System.out.println("Number of Lines in the File :"+ countLines);

        //Displaying the number of words in the file
        System.out.println("Number of Words in the File :"+ countWords);

        //Displaying the number of characters in the file
        System.out.println("Number of Characters in the File :" + countCharacters);
    }
}



