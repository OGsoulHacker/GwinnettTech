import java.util.Scanner;
public class twoDgAfterDecimal {
    public twoDgAfterDecimal() {
        }
            public static void main(String[] args) {
                double purchaseAmount;
                Scanner input = new Scanner (System.in);

                    System.out.print("Enter purchase amount: ");
                    purchaseAmount = input.nextDouble();

                double tax = purchaseAmount * 0.06;
                System.out.println("Sales tax is " + (int) (tax * 100) / 100.0);
            }
        }
