//Scanner class
import java.util.Scanner;
public class J1_lab3_03 {
    public J1_lab3_03(){
    }
    public static void([], args){
        Scanner input = new Scanner(System.in);
        // Declarations
        int lottery = (int)(Math.random() * 1000);
        System.out.println("Enter your pick 3 lottery numbers");
        int guess = input.nextInt();
        //1.your test value: number =
        if (number % 2 == 0 && number % 3 == 0)
            System.out.println(number + " is divisible by 2 and 3.");
        if (number % 2 == 0 || number % 3 == 0)
            System.out.println(number + " is divisible by 2 or 3.");
        if (number % 2 == 0 ^ number % 3 == 0)
            System.out.println(number + " divisible by 2 or 3, but not both.");
        //your output:
        //2.your test value:
        int year = 2004;
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        isLeapYear = int year;

        //3.your test value: lottery = 10000, LotteryDigit1=7, LotteryDigit2=3
        if (guess == lottery)
            System.out.println("Exact match: you win $10,000");
        else if (Digit2 == LotteryDigit1 && Digit1 == LotteryDigit2)
            System.out.println("Match all digits: you win $3,000");
        else if (Dg1 == LottteryDigit1 || Digit1 == LotteryDigit2 || Digit2 == LotteryDigit1 || Digit2 == LotteryDigit2)
            System.out.println("Match one digit: you win $1,000");
        else
            System.out.println("Sorry, no match");
    }
}
