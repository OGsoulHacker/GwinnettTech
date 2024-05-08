//Scanner class
import java.util.Scanner;
    public class J1_Lab03_3 {
        public J1_Lab03_3() {
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);


            //1.your test value: number =
            System.out.println("================================================================================");
            System.out.println("Please enter a number:");
            int number = input.nextInt();
            if (number % 2 == 0 && number % 3 == 0)
                System.out.println(number + " is divisible by 2 and 3.");
            if (number % 2 == 0 || number % 3 == 0)
                System.out.println(number + " is divisible by 2 or 3.");
            if (number % 2 == 0 ^ number % 3 == 0)
                System.out.println(number + " divisible by 2 or 3, but not both.");
            //your output:
            //2.your test value:
            System.out.println("================================================================================");
            System.out.println("Enter a year");
            int year = input.nextInt();
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            System.out.println(year + "is a leap year" + isLeapYear);


            //3.your test value: lottery = 10000, LotteryDigit1=7, LotteryDigit2=3
            System.out.println("=================================================================================");
            int lottery = (int) (Math.random() * 100);
            System.out.println("Enter your pick two lottery numbers");
            int guess = input.nextInt();
            // Get digits from lottery
            int LotteryDigit1 = lottery / 10;
            int LotteryDigit2 = lottery % 10;
            // Get digits from guess
            int Digit1 = guess / 10;
            int Digit2 = guess % 10;
            // code exact match
            if (guess == lottery)
                System.out.println("Exact match: you win $10,000");
            // Numbers but not exact
                else if (Digit2 == LotteryDigit1 && Digit1 == LotteryDigit2)
                    System.out.println("Match all digits: you win $3,000");
            // Numbers but not exact
                else if (Digit1 == LotteryDigit1 || Digit1 == LotteryDigit2 || Digit2 == LotteryDigit1 || Digit2 == LotteryDigit2)
                    System.out.println("Match one digit: you win $1,000");
                else
                    System.out.println("Sorry, no match");
        }
    }