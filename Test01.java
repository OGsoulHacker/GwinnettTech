//This program is for converting Farenheit to Celsius.
import java.util.Scanner;
public class Test01
{
    public static void main(String[] args)
    {
        //Create scanner object
        Scanner input = new Scanner(System.in);
        //Gathering user input for temp in F.
        System.out.print("Enter Temp in farenheit");
        System.out.print("Farenheit:");
        double tempF = input.nextDouble();
        // Converts temp F to C
        double tempC = (5.0 / 9) * (tempF - 32);
        //Display temp
        System.out.println("Farenheit temp of" + tempF + " is " + tempC + " in degrees of Celsius.");
    }
}