package ControlFlowStatements;

public class FirstAndLastDigitSum {
    public static void main(String[] args) {
        int sum = sumFirstAndLastDigit(10);
        System.out.println("Sum is : " + sum);
    }
    public static int sumFirstAndLastDigit (int number) {
// if number is negative method will return -1.
        if (number < 0){
            return -1;
        }
        int lastNum = 0;
        int sum = 0;
        int firstNum = number % 10;
        lastNum = number % 10;

        while (number >= 10) {
            number = number /10;
            firstNum = number % 10;
        }
        sum = firstNum + lastNum;
        return sum;
    }
}
