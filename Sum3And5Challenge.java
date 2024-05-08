package ControlFlowStatements;

public class Sum3And5Challenge {
    public static void main(String[] args) {
/*Sum 3 and 5 challenge
*       >Create a For statement using a range or 1 to 1000 inclusive
*       >Sum all the numbers that can be divided with both 3 and also with 5
*           -For those numbers that meet the above conditions, print out the number
*       >break out of the loop once you find 5 numbers that met the above conditions
*           -After breaking out of the loop print the sum of the numbers that met the
*            above conditions
 */
        int sum = 0; //Initalizes sum
        int count = 0; //Initializes count
        for (int i = 0; i <=1000; i++){ //create range of 1 to 1000
            if ((i % 3 == 0) && (i % 5 == 0)){ //checks for remainder of 3 and 5, if no remainder the num divides evenly
                count++; //Increments count
                sum+=i; // sum what has been found thus far
                System.out.println("Number found: " + i);//Prints value and sums value
            }
            if (count == 5){ //Tests to see if 5 numbers have been found.
                break;
            }
        }
        System.out.println("Sum: " + sum); //Prints sum
    }
}
