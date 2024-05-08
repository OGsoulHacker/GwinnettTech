import java.util.Scanner;
public class lab02 {
        public lab02(){
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            }
        //Declarations
        String myName = "Alexis Shiman";
        char middle = 'R';
        int age = 33;
        double pi = 3.141592;
        double pi4 = pi - 0.00005;
// Information for section A
        System.out.println("=================================================================");
        System.out.print("What is your name?");
        String myName = input.nextLine();
        System.out.print(System.lineSeparator());
        System.out.print("What is your middle initial?");
        char middle = input.nextChar();
        System.out.print("How old are you?");
        int age = input.nextInt();
        System.out.print(System.lineSeparator());
        System.out.print("What is pi?");         double pi = input.nextDouble();
        System.out.print(System.lineSeparator());
// Information for section B
        System.out.println("=================================================================");
        System.out.println("Name:" +myName);
        System.out.println("Middle:" +middle);
        System.out.println("Age:" +age);
        System.out.println("Pi:" + pi);
// Information for section c
        System.out.println("=================================================================");
        System.out.printf("Pi: %f", pi);
        System.out.print(System.lineSeparator());
        System.out.printf("Pi: %.5f", pi);
        System.out.print(System.lineSeparator());
// Double pi4 drops decimal to prevent rounding up.
        System.out.printf("Pi: %.4f", pi4);
        System.out.print(System.lineSeparator());
        System.out.printf("Pi: %.2f", pi);
    }
}
