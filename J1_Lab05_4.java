import java.util.Scanner;
    public class J1_Lab05_4 {
        /** Main method */
        public static void main(String[] args) {
            // Create a Scanner
            Scanner input = new Scanner(System.in);

            // Prompt the user to enter a string
            System.out.print("Enter a string: ");
            String s = input.nextLine();

            // The index of the first character in the string
            int a = 0;

            // The index of the last character in the string
            int b = s.length() - 1;

            boolean isPalindrome = true;
            while (a < b) {
                if (s.charAt(a) != s.charAt(b)) {
                    isPalindrome = false;
                    break;
                }

                a++;
                b--;
            }

            if (isPalindrome)
                System.out.println(s + " is a palindrome");
            else
                System.out.println(s + " is not a palindrome");
        }
    }

