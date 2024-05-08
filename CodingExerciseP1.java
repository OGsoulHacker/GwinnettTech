package keywordsExpressionsExpressionsStatements;

public class CodingExerciseP1 {
    public static void main(String[] args) {
        /* 1.) Write a method called toMilesPerHour:
         *      -has 1 parameter of type double with the name kilometersPerHour
         *      -returns the rounded value of the calculation of type long
         *          -if the parameter kilometersPerHour is less than 0
         *              -method toMilesPerHour needs to return -1 to indicate invalid value
         *          -otherwise if it is positive, calculate the value of miles per hour
         *              -round it and return it
         * 2.) Write another method called printConversion
         *      - has 1 parameter of type double with the name kilometersPerHour
         *      -method will not return anything (void)
         *      -needs to calculate milesPerHour from the kilometersPerHour Parameter
         *      -then it needs to print a message in the format: "XX kn/h = YY mi/h"
         *          -XX represents the original value from the kilometersPerHour
         *          -YY represents the rounded milesPerHour parameter
         *      -if the parameter kilometersPerHour is < 0 then print "Invalid Value
         */
 //       long miles = SpeedConverter.toMilesPerHour(10.5);
 //       System.out.println("Miles = " + miles );
 //       SpeedConverter.printConversion(10.5);

        boolean leapYear = LeapYear.isLeapYear(-1600);
        System.out.println("leapyear " +leapYear);
    }
}
