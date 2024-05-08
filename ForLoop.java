package ControlFlowStatements;

public class ForLoop {
    public static void main(String[] args) {
        System.out.println(("10,000 at 2% interest:") + calculateInterest(10000.0, 2.0));
        System.out.println(("10,000 at 3% interest:") + calculateInterest(10000.0, 3.0));
        System.out.println(("10,000 at 4% interest:") + calculateInterest(10000.0, 4.0));
        System.out.println(("10,000 at 5% interest:") + calculateInterest(10000.0, 5.0));

        for (int i = 0; i < 5; i++) {
            System.out.println("Loop " + i + " Hello");
        }
        System.out.println("--------------------------------------------------------------------------------------");

        /*Using the For statement do the following:
         *   >Call the calculateInterest method
         *       -use amount 10,000 with an interest of 2,3,4,5,6,7, and 8
         *       -print the result to the console window
         */
        for (int i = 2; i < 9; i++) {
            System.out.println("10,000 at " + i + " %interest " + String.format("%.2f", calculateInterest(10000.0, i)));
        }
        System.out.println("--------------------------------------------------------------------------------------");
        /*Modify the above For loop:
         *   > start from 8% and work back to 2%
         */
        for (int i = 8; i > 1; i--) {
            System.out.println("10,000 at " + i + " %interest " + String.format("%.2f", calculateInterest(10000.0, i)));
        }
        System.out.println("--------------------------------------------------------------------------------------");
        /*Create For statement using any range of numbers:
         *   >Determine if the number is a prime number using the isPrime method
         *   >If number is prime number
         *       -print out AND increment  a count of number of prime numbers found
         *       -if count is 3 exit the For loop
         * (HINT: use the break statement; to exit)
         */
        int count = 0;//count for number of prime numbers found
        for( int i = 6; i < 50; i++){
            if (isPrime(i)) {//if prime number is found it is returned as true
                count++;
                System.out.println("Number " + i + " is a prime number.");
                if (count ==10){//if 3 prime numbers are found exit for loop
                    System.out.println("Exiting the For loop");
                    break;
                }
            }

        }
    }


    public static boolean isPrime(int n) {//determines whether past int is a prime number
        if (n == 1) { //has to be whole number greater than 1
            return false;
        }
        for (int i = 2; i <= (long) Math.sqrt(n); i++) { //trying to find numbers that divide into 2 evenly
            System.out.println("Looping " + i);
            if (n % i == 0) {// checks for remainder if there is a remainder it is not prime num
                return false;
            }
        }
        return true;
    }

    public static double calculateInterest(double amount, double interestRate){
        return (amount * ( interestRate / 100) );
    }



}
