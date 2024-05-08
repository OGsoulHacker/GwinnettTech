import java.util.Scanner;
public class J1_Lab03_2 {
        public J1_Lab03_2() {
        }
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
        //Declarations
            final double heightFt;
            final double Meters_Per_Inch = 0.0254;
        //User inputs
            System.out.print("Enter height in feet. (Ex: 5.7 = 5)");
            heightFt = input.nextDouble();
            System.out.print("Enter height in inches (ex: 5.7 =7)");
            int heightIn = input.nextInt();
            System.out.print("Enter weight in pounds: ");
            double weight = input.nextDouble();
        //Height calculation section
            System.out.println("Height(ft):" + heightFt);
        // Convert height to In, then meters per In
            double heightInMeters = ((heightFt*12) + heightIn) * Meters_Per_Inch;
            System.out.println("Height(In):" + heightIn);
        //Weight calculation section
            System.out.println("Weight(lb):" + weight);
            final double KILOGRAMS_PER_POUND = 0.45359237;
            double weightInKilograms = weight * KILOGRAMS_PER_POUND;
        //BMI section output
            double bmi = weightInKilograms /
                    (heightInMeters * heightInMeters);
           // int BMI = (int) bmi;
            System.out.printf("BMI is: %.4f", bmi);
            System.out.print(System.lineSeparator());
            if (bmi < 18.5)
                System.out.println("Underweight");
            else if (bmi < 25)
                System.out.println("Normal");
            else if (bmi < 30)
                System.out.println("Overweight");
            else
                System.out.println("Obese");
        }
    }

