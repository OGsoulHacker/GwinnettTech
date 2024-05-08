package ControlFlowStatements;

public class AllFactors {
    public static void main(String[] args) {

    }
    public static void printFactors (int number){
        String factors = "";//Creates empty string for print statement

        // tests for valid values
        if (number < 1) {
            System.out.println("Invalid Value");
        }

        // Calculate factors of given number
        for (int i = 1; i<= number ;i++){
            if(number % i == 0){
                factors = factors + i + " ";
            }
        }

        // Print Factors
        System.out.println(factors);
    }
}
