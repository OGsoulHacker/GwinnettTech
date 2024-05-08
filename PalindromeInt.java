import java.util.Scanner;
public class PalindromeInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a three digit integer.");
        int digits = input.nextInt();
        boolean palindrome = (digits / 100 == (digits % 10));
        if(palindrome)
                System.out.println("Palindrome");
        else
            System.out.println("Not palindrome");
    }
}
