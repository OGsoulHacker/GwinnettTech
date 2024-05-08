package hello;
import java.util.Scanner;
/*Occurrences of a specified character in an array
    > Write a recursive method that finds the number of
    occurrences of a specified character in an array.
    > You need to define the following 2 methods:
        * public static int count(char[] chars, char ch)
        * public static int count(char[], chars, char ch, int high)
            - second method is a recursive helper method
    > Write a program that prompts the user to enter a list
    of characters in one line, and displays the number of
    occurrences of the character in the list.
*/
public class RecursiveSpecifiedCharArray {

    public static int count(char[] chars, char ch) {
        int count = 0; //Variable count initialization
        //int i is index, index less than length, index will increase
        for (int i = 0; i < chars.length; ++i) {
            //if index of character array is equal to character
            if (chars[i] == ch) {
                count++;
            }
        }
        return count;
    }

    //Recursive Helper method
    public static int count(char[] chars, char ch, int high) {
        //if
        if (chars.length == high) {
            return 0;
        } else {
            return (ch == chars[high] ? 1 : 0) + count(chars, ch, high + 1);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);
        System.out.println(ch + " appears " + count(str.toCharArray(), ch) + " times");
        System.out.println(ch + " appears " + count(str.toCharArray(), ch, 0) + " times");
    }
}

