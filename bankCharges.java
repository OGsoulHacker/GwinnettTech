package hello;
import java.util.Scanner; // Import the Scanner class
/* A bank charges a base fee of $10 per month, plus the following check fees for a commercial
    checking account:

        $.10 each for less than 20 checks
        $.08 each for 20–39 checks
        $.06 each for 40–59 checks
        $.04 each for 60 or more checks
Write a program that asks for the number of checks written for the month.
The program should then calculate and display the bank’s service fees for the month.
 */
public class bankCharges {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //initialization of variables
        double baseFee = 10.00;
        double checkFee = 0;

        System.out.println("Welcome to Wells Fargo!");
        System.out.println("Enter number of checks written this month: ");
        double numOfChecks = input.nextDouble();

        if (numOfChecks < 60) {
            if (numOfChecks >= 40) {
                checkFee = baseFee + 0.06;//Service fee for the month
                System.out.println("Monthly Service Fee: $" + checkFee);
            } else if (numOfChecks >= 20) {
                checkFee = baseFee + 0.08;//Service fee for the month
                System.out.println("Monthly Service Fee: $" + checkFee);
            }else{
                checkFee = baseFee + 0.10;//Service Fee for the month
                System.out.println("Monthly Service Fee: $" + checkFee);
            }
        }else{
            checkFee = baseFee + 0.04;//Service fee for the month
            System.out.println("Monthly Service Fee: $" + checkFee);
        }
    }
}
