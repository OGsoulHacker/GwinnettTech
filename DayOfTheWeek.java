package ControlFlowStatements;

public class DayOfTheWeek {
/*Day of the week challenge
*   >Write a method named printDayOfTheWeek
*       -Has one parameter: int day
*       -method should not return any value
*           >Using a switch statement print:
*               -"Sunday,"monday", ...., "Saturday"
*               -if the int parameter is 0-6, else print "Invalid day"
*/
    public static void main(String[] args) {
        printDayOfTheWeek(-1);
        printDayOfTheWeek(0);
        printDayOfTheWeek(1);
        printDayOfTheWeek(2);
        printDayOfTheWeek(3);
        printDayOfTheWeek(4);
        printDayOfTheWeek(5);
        printDayOfTheWeek(6);
        printDayOfTheWeek(7);
    }
    public static void printDayOfTheWeek(int day){
        switch (day){
            case 0:
                System.out.println("Day is Sunday" );
                break;
            case 1:
                System.out.println("Day is Monday");
                break;
            case 2:
                System.out.println("Day is Tuesday");
                break;
            case 3:
                System.out.println("Day is Wednesday");
                break;
            case 4:
                System.out.println("Day is Thursday");
                break;
            case 5:
                System.out.println("Days is Friday");
                break;
            case 6:
                System.out.println("Day is Saturday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }
    }
}
