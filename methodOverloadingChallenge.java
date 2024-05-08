package keywordsExpressionsExpressionsStatements;
public class methodOverloadingChallenge {
    public static void main(String[] args) {
        double centimeters = calcFeetAndInchesToCentimeters(7,10);
        if ( centimeters < 0.0) {
            System.out.println("Invalid parameters");
        }
        calcFeetAndInchesToCentimeters(7);
    }
    /*create a method called calcFeetAndInchesToCentimeters
        -needs to have two parameters: feet, inches
        -should validate that inches is >=0 or <=12
            -return -1 if either of the above is not true
        -if the parameters are valid
            -calculate how many centimeters comprise the feet and inches passed to the method
            -return that value
                -1 inch = 2.5 cm and 1 foot = 12 inches
     */
    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if ((feet < 0) || (inches < 0) || (inches > 12)) {
            System.out.println("Invalid feet or inches parameters");
            return -1;
        }
        double centimeters = (feet * 12) * 2.54;
        centimeters+= inches * 2.54;
        System.out.println(feet + "feet, " + inches + " inches " + centimeters + "cm");
        return centimeters;
    }
    /*Create second method with the same name
        -only one parameter: inches
        -Validate that it's >=0
            -return -1 if it is not true
        -if valid
            -calculate how many feet are in inches
            -call the other overloaded method passing the correct feet and inches
     */
    public static double calcFeetAndInchesToCentimeters(double inches){
        if (inches < 0) {
            return -1;
        }
            double feet = (int) inches / 12;
            double remainingInches = (int) inches % 12;
        System.out.println(inches + " inches is equal to " + feet + " feet and " + remainingInches + "inches");
            return calcFeetAndInchesToCentimeters(feet, remainingInches);
        }
    }
