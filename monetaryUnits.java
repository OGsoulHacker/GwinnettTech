 import java.util.Scanner;
    public class monetaryUnits {
            public static void main (String[]args){
                Scanner input = new Scanner(System.in);


       //Receive the amount
            System.out.print("Enter an amount.");
                double amount = input.nextDouble();
                    int remainingAmount = (int)(amount * 100);
       //Find the number of one dollars.
                int numberOfOneDollars = remainingAmount / 100;
                    remainingAmount = remainingAmount %100;
       //Find number of quarters
                int numberOfQuarters = remainingAmount / 25;
                    remainingAmount = remainingAmount %25;
       //Find number of dimes in the remaining amount.
                int numberOfDimes = remainingAmount / 10;
                    remainingAmount = remainingAmount %10;
       //Find the number of nickels in remaining amount.
                int numberOfNickles = remainingAmount / 5;
                    remainingAmount = remainingAmount %5;
       //Find number of pennies in remaining amount.
                int numberOfPennies = remainingAmount;
       // Display results.
                System.out.println("Your amount   " + amount + "   consists of");
       //Dollars
                    if (numberOfOneDollars == 1) {
                        System.out.println("Dollar:" + numberOfOneDollars);
                    } if (numberOfOneDollars > 1) {
                        System.out.println("Dollars:" + numberOfOneDollars);
                }
       //Quarters
                    if (numberOfQuarters ==1) {
                        System.out.println("Quarter:" + numberOfQuarters);
                    } if (numberOfQuarters >1 ){
                        System.out.println("Quarters:" + numberOfQuarters);
                    }
       //Dimes
                    if (numberOfDimes == 1) {
                        System.out.println("Dime:" + numberOfDimes);
                    } if (numberOfDimes > 1) {
                        System.out.println("Dimes:" + numberOfDimes);
                    }
       //Nickles
                    if (numberOfNickles == 1) {
                        System.out.println("Nickle:" + numberOfNickles);
                    } if(numberOfNickles > 1) {
                        System.out.println("Nickles:" + numberOfNickles);
                    }
       //Pennies
                    if (numberOfPennies == 1) {
                        System.out.println("Penny:" + numberOfPennies);
                    }if (numberOfPennies > 1) {
                        System.out.println("Pennies:" + numberOfOneDollars);
                }

            }
        }