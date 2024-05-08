package keywordsExpressionsExpressionsStatements;

public class CodingExercises {
    public static void main(String[] args) {
        /*Write a method called checkNumber with an int parameter number
         *  -method should not return any value, and it needs to print out:
         *      -"positive" if the parameter number is > 0
         *      - "negative" if the parameter number is < 0
         *      - "zero" if the parameter number is equal to 0
         */
        checkNumber(5);
        checkNumber(-10);
    }
        public static void checkNumber ( int number){
            if (number > 0) {
                System.out.println("Positive");
            } else if (number < 0) {
                System.out.println("Negative");
            } else if (number == 0) {
                System.out.println("Zero");
            }
        }
    }

