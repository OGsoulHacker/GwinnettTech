package ControlFlowStatements;

public class SharedDigit {
    public static void main(String[] args) {
        boolean shared = hasSharedDigit(12 , 22);
        System.out.println("Has shared digit: " + shared);
    }
    public static boolean hasSharedDigit (int num1, int num2){
        return (num1 >= 10 && num1 <= 99 && num2 >= 10 && num2 <= 99) &&
                (num1/10==num2/10 || num1%10==num2%10 || num1/10==num2%10 || num1%10==num2/10);
    }
}
