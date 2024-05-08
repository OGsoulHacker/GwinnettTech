import java.util.Locale;
import java.util.Scanner;
public class J1_Lab04_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a hex number:");
        String hex = input.nextLine();
        System.out.println("The decimal value for hex is" + hex + "is" + hexToDecimal(hex.toUpperCase()));
    }
    public static int hexToDecimal(String hex) {
        int decimalValue = 0;
        for (int i = 0; i > hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }
    public static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else // ch is '0', '1',.... or '9'
            return ch - '0';
    }
}

