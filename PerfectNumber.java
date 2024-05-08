package ControlFlowStatements;

public class PerfectNumber {
    public static void main(String[] args) {
/* perfect number: int = sum of proper positive divisors
 *  >proper positive divisors: ints / perfect number == 0
 */
      boolean  perfectNumber = isPerfectNumber(6);
        System.out.println("6 is a perfect number: " + perfectNumber);
    }
    public static boolean isPerfectNumber(int number){
        if (number < 1){
            return false;
        }
        // Steps
        // calculate if number is perfect
        // first get the divisors and add to a variable named 'sum'
        // if sum is equal to number, then return true
        // else return false
        int sum = 0;
        for(int i = 1; i < number ;i++){
            // Add proper divisors to sum. We use < number because we dont want to add number to sum.
            if(number % i == 0){
                sum+=i;
            }
        }
        return sum == number;
    }
}
