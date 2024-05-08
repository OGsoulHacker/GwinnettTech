package hello;
import java.io.*;
import java.util.Arrays;
import java.lang.Math;
import java.util.Random;

/* 12.15: Write/read data
    Write a program to create a file named: Exercise12_15.txt if it does not exist,
    Write 100 integers created randomly into the file using text I/O.
    Integers are separated by spaces in the file. Red the data back from the file
    and display the data in increasing order
*/
public class Lab04_12_15 {
    // Import Necessary packages
    public class JavaCreateFileRead {
        public static void main(String[] args) throws IOException {

            // Generate an Array of 100 integers
            int[] myArray = new int[100];
            File file = new File("Exercise12_15.txt");
            //If file does not exist create array
            if(!file.exists())
            {
                for(int i = 0; i < myArray.length; i++)
                {
                    myArray[i] = (int)(Math.random() * 100);//Creates an array with 100 randomly chosen integers
                }
                // Create file if it does not exist
                FileWriter writer = new FileWriter("Exercise12_15.txt", true);
                writer.write(Arrays.toString(myArray));
                // write new line
                writer.write("\r\n");
                writer.close();
            }
            // Reading the file
            FileReader reader = new FileReader("Exercise12_15.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        }
    }
}
