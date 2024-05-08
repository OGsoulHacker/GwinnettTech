package ControlFlowStatements;

public class IsOddChallenge {
    /*Is Odd Challenge:
     *   >Write a method called isOdd
     *       -1 int parameter, returns a boolean
     *           -Check the number is > 0, if not return false
     *               -If number is odd return true, otherwise return false
     *   >Write a second method called: sumOdd
     *       -2 int parameters: start, and end(represents range of numbers
     *       -Method should use a For loop to sum all odd numbers in that range
     *           -including end, and return sum
     *       -should call method isOdd to check if number is odd
     *       -parameter end needs to be greater than or equal to start
     *           -both start and end parameters have to be greater than 0
     */
    public static void main(String[] args) {

    }

    public static boolean isOdd(int number) {
        if (number > 0) {
            if (number % 2 != 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;
        if ((end >= start) && (start > 0) && (end > 0)) {
            for (int i = start; i <= end; i++) {
                if (isOdd(i)) {
                    sum += i;
                }
            }
            return sum;
        }
        return -1;
    }
}

