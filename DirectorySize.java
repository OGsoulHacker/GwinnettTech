package hello;

import java.io.File;//Importing file class
//Importing invalid InvalidParameter exception class
import java.security.InvalidAlgorithmParameterException;
//Importing all classes of util package
import java.security.InvalidParameterException;
import java.util.*;
/*Directory size
 ===============
    > Listing 18.10 gives, DirectorySize.java, gives a recursive method
      for finding a directory size. Rewrite this method without using
      recursion. Your program should use a queue to store the
      subdirectories under a directory. The algorithm can be described
      as follows:
        * long getSize(File directory) {
            long size = 0;
            add directory to the queue

            while (queue is not empty) {
              Remove an item from the queue into it;
              if (T is a file) {
                size += t.length()
              }else {
                 add all the files and subdirectories under t into the queue;
              }
              return size;
            }
          }
*/
public class DirectorySize {
    //Creating main method
    public static void main(String[] args) {
        String FILEPATH = "file.txt"; // Storing file path in string variable
        File file = new File(FILEPATH); //Creating file class object
        //Checking if specified file is valid or not
        if (!file.isDirectory() && !file.isFile()) {
            throw new InvalidParameterException("Not a file in directory");
        }
        //Checking for directory or file
        String dOrF = (file.isDirectory()) ? "Directory" : "File";
        System.out.println(dOrF + "size = " + getSize(file));
    }
    //Get size of file
    public static long getSize (File file){
        long size = 0;
        //Creating queue class
        Queue<File> queueObj = new LinkedList<>();
        //Inserting the specified file into the queue
        queueObj.offer(file);
        //while (queue is not empty)
        while (!queueObj.isEmpty()) {
            file = queueObj.poll();
            if (file.isFile()) {
                size += file.length();
            } else {
                //add all the files and subdirectories under file into the queue;
                //Store the array of file pathnames
                File[] files = file.listFiles();
                if (files != null) {
                    Collections.addAll(queueObj, files);
                }
            }
        }
        //Returning size;
        return size;
    }
}