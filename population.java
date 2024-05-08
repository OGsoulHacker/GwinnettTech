package hello;
import java.util.Scanner;
import java.text.*;
/* Write a program that will predict the size of a population or organisms.
   The program should ask for:
        - Starting number of organisms
        - Average daily population increase(as a percentage)
        - Number of days they will multiply
            Example:
            A population might begin with 2 organisms, have an average daily increase of 50%,
            and will be allowed to multiply for 7 days. The program should use a loop to display
            the size of the population for each day.

   Input validation: Do not accept numbers less than 2 for the starting population size.
   Do not accept a negative number for average daily population increase.
   Do not accept a number less than 1 for the number of days they will multiply

 */
public class population {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            int daystoMultiply;
            double numOfOrganism = 0;
            double avgIncrease = 0;

            System.out.print("Please do Enter Total Number of of organisms: ");
            numOfOrganism = input.nextDouble();// enter number of organisms

            while( numOfOrganism < 2){// accept number of organisms only greater than 2
                System.out.print("Please do enter a value which is  greater than 1: ");
                numOfOrganism = input.nextDouble();
            }

            System.out.print("Please do enter Percentage of average daily population increase: ");
            avgIncrease = input.nextDouble()/100;// Prompt user for the rate of increase in percentage

            while( avgIncrease < 0){// enter only positive percent
                System.out.print("enter only positive percent value above 0: ");
                avgIncrease = input.nextDouble();
            }

            System.out.print("Enter the Total Number of days greater than 0 to multiply: ");
            daystoMultiply  = input.nextInt();// Allow user to enter the number of days

            while(daystoMultiply < 1){
                System.out.print("Please do enter a value which is greater than 0: ");
                daystoMultiply  = input.nextInt();
            }

            System.out.println("");

            //format to 2 decimal point
            NumberFormat numf = DecimalFormat.getInstance();
            numf.setMaximumFractionDigits(2);

            System.out.println("Day" +"       Population Today" + "       Total Percent of Increase in population");
            System.out.println("==============================================================================");
            System.out.println("  1           " + numf.format(numOfOrganism));          //output of day 1 will be current input numOfOrganism

            for(int i=2; i<daystoMultiply + 1; i++){ // for loop to start from day 2 till n+1 to cover daystoMultiply
                numOfOrganism += (numOfOrganism *= avgIncrease);// adding up the product of average increase and number of organism each day
                System.out.println("  " +i + "           " + numf.format(numOfOrganism) + "                " + (avgIncrease*100)+"%");
            }
        }
    }
