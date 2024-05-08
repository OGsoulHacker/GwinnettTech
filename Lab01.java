import java.util.Scanner;
public class Lab01 {
    public static void main(String[] args) {

        String myName;
        String middle;
        int age;
        Scanner input = new Scanner(System.in);

        // Information for section A.
        System.out.println("==================================================");
        System.out.print("What is your name?");
        myName = input.nextLine();
        System.out.print(System.lineSeparator());
        System.out.print("What is your middle initial?");
        middle = input.next();
        System.out.print(System.lineSeparator());
        System.out.print("How old are you?");
        age = input.nextInt();
        System.out.print(System.lineSeparator());
        System.out.print("What is pi?");
        final double pi = input.nextDouble();
        System.out.print(System.lineSeparator());
        //Information for section B.
        System.out.println("================================================");
        System.out.println("Name:" + myName);
        System.out.println("Middle:" +middle);
        System.out.println("Age:" +age);
        System.out.println("Pi:" + pi);
        //Information for section C.
        System.out.println("==================================================");
        System.out.print(System.lineSeparator());
        System.out.printf("Pi: %f", pi);
        System.out.print(System.lineSeparator());
        System.out.printf("Pi: %.5f", pi);
        System.out.print(System.lineSeparator());
        // Double pi4 to drop decimal
        double pi4 = pi - 0.00005;
        System.out.printf("Pi:" +"%.4f ",pi4);
        System.out.print(System.lineSeparator());
        System.out.printf("Pi: %.2f",pi);
        }
    }
