package hello;
import java.util.Scanner;
/*Write a program that asks the user to enter five test scores. The program should display a
letter grade for each score and the average test score. Write the following methods in the program:

CalcAverage—This method should accept five test scores as arguments and return the average of the scores.
determineGrade—This method should accept a test score as an argument and return a letter grade for the score,
based on the following grading scale:

Score  Letter Grade
90-100 A
80-89  B
70-79  C
60-69  D
 */
public class testAvgAnGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);// Create scanner object for input

        //Initialize
         double score1, // first Score
                score2, // Second Score
                score3, // Third Score
                score4, // fourth Score
                score5; // fifth score
        double averageReturned;// Average test score

        // Get score 1
        System.out.print("Enter your first score ");
        score1 = input.nextDouble();//user input
        double grade1 = determineGrade(score1);//calls determineGrade method
        // Get score 2
        System.out.print("Enter your second score ");
        score2 = input.nextDouble();//user input
        double grade2 = determineGrade(score2);//calls determineGrade method
        // Get score 3
        System.out.print("Enter your third score ");
        score3 = input.nextDouble();//user input
        double grade3 = determineGrade(score3);//calls determineGrade method
        // Get score 4
        System.out.print("Enter your fourth score ");
        score4 = input.nextDouble();//user input
        double grade4 = determineGrade(score4);//calls determineGrade method
        // Get score 5
        System.out.print("Enter your fifth score ");
        score5 = input.nextDouble();//user input
        double grade5 = determineGrade(score5);//calls determineGrade method
        averageReturned = CalcAverage(score1, score2, score3, score4, score5);//calls CalcAverage method
        System.out.println(" Your average is :" + averageReturned);//Returns average

    }
//method should accept five test scores as arguments and return the average of the scores.
    public static double CalcAverage(double score1, double score2, double score3, double score4, double score5)
    {
        double average = (( score1 + score2 + score3 + score4 + score5) / 5);
        //System.out.println(average);
        return average;
    }
//This method should accept a test score as an argument and return a letter grade for the score
    public static double determineGrade(double score)
    {
        if (score >= 90) {
            System.out.println("You got an A");
        } else if (score >= 80) {
            System.out.println("You got a B");
        } else if (score >= 70) {
            System.out.println("You got a C");
        } else if (score >= 60) {
            System.out.println("You got a D");
        } else if (score < 60) {
            System.out.println("You got an F");
        }
        return 0; //return statement.
    }
}
