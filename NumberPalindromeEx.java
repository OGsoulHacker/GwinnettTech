package ControlFlowStatements;

public class NumberPalindromeEx {
    public static void main(String[] args) {
       boolean palindrome = isPalindrome(707);
        System.out.println("707 is a palindrome: " + palindrome);
    }
    public static boolean isPalindrome(int number){
        int reverse = 0; //create a reverse variable
        int lastDigit = 0;//create a lastDigit variable
        int num = number;
        //make a while or do while loop below. the loop condition should be while number >= 0
        while (num != 0){//includes negative number palindromes
            lastDigit = num % 10 ; //takes the last Digit off of number
            num/=10;
            reverse = (reverse * 10) + lastDigit;
        }
        if (reverse == number){ //if number equal to reverse
            return true;
        }else{
            return false;
        }
    }
}
