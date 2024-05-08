package ControlFlowStatements;

public class DigitSumChallenge {
/*Digit Sum Challenge
 *  > /Write method named sumDigits(int number)
 *      -if parameter is >=10 method should process the number,
 *       and return sum of all digits, otherwise return -1 to indicate invalid value
 *      -Numbers 0-9 have 1 digit, we do not want to process them
 *      -nor do we want to process negative numbers, return -1 for negative numbers
 * EXAMPLE: sumDigits(125) should return 8 since 1+2+5=8
 *          sumDigits(1) should return -1
 * HINT*
 * -use n % 10 to extract least-significant digit
 * -use n = n / 10 to discard least significant digit
*/
    public static void main(String[] args) {
       int digits = sumDigits(125);
        System.out.println("Sum of digits:" + digits);
    }
 //1. Write method named sumDigits(int number)
    public static int sumDigits(int number){
        int sum = 0;

        if (number < 0) {
            return -1;
        }
//-Numbers 0-9 have 1 digit, we do not want to process them
// *      -nor do we want to process negative numbers, return -1 for negative numbers
        if (number < 10 && number > 0) {
            return -1;
        }
        do{
            sum+= number % 10; // extract least-significant digit
            number = number / 10; // discard least significant digit
        } while (number >= 10);
        sum += number;

        return sum;//return sum of all digits
    }
}
