import java.util.Scanner;
public class J1_Lab03_4 {
        public J1_Lab03_4() {
        }

        public static void main(String[] args) {
                Scanner day = new Scanner(System.in);
                int enteredDay = day.nextInt();

                if (enteredDay > 7) {
                        enteredDay = enteredDay % 7;
                }

                switch (enteredDay) {
                        case 1:
                                System.out.println("Monday");
                                break;
                        case 2:
                                System.out.println("Tuesday");
                                break;
                        case 3:
                                System.out.println("Wednesday");
                                break;
                        case 4:
                                System.out.println("Thursday");
                                break;
                        case 5:
                                System.out.println("Friday");
                                break;
                        case 6:
                                System.out.println("Saturday");
                                break;
                        case 7:
                                System.out.println("Sunday");
                                break;
                }
        }
}