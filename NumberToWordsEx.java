package ControlFlowStatements;

public class NumberToWordsEx {
    public static void main(String[] args) {

    }

    public static void numberToWords(int number){
 //method should print out passed number using words for digits
        // Check if the number is less than 0, or if number == 0;
        if(number < 0){
            System.out.println("Invalid Value");
        }else if(number == 0){
            System.out.println("Zero");
        }
        // get the digit count in the original number using the method getDigitCount(int number);
        int digitNum = getDigitCount(number);
        // Get the reverse of the original number to solve reversed word printing, use method reverse(int number)
        number = reverse(number);
        // Get digit count for the reversed number;
        int revDigitNum = getDigitCount(number);
        // Declare variable to hold the extracted digit in string
        String lastDigitInWord = "Zero";
        // Use while loop to get the last digit value;

        while(number>0){
            int lastDigit = number%10;
            // use switch to assign the last digit to it's corresponding word.
            switch(lastDigit){
                case 0: lastDigitInWord = "Zero";
                    break;
                case 1: lastDigitInWord = "One";
                    break;
                case 2: lastDigitInWord = "Two";
                    break;
                case 3: lastDigitInWord = "Three";
                    break;
                case 4: lastDigitInWord = "Four";
                    break;
                case 5: lastDigitInWord = "Five";
                    break;
                case 6: lastDigitInWord = "Six";
                    break;
                case 7: lastDigitInWord = "Seven";
                    break;
                case 8: lastDigitInWord = "Eight";
                    break;
                case 9: lastDigitInWord = "Nine";
                    break;
                default:
                    System.out.println("invalid value");
            }
            // Print the lastDigitInWord to the screen each in a new line;
            System.out.println(lastDigitInWord);
            number /= 10;
        }
        // use for loop to print "Zero" as long as i less than the original digitNum variable
        // we declared later, and i is assigned to the revDigitNum variable which is always less than
        // digitNum where ever there is a leading ZERO in the original number
        for(int i = revDigitNum; i<digitNum; i++){
            System.out.println("Zero");
        }
    }

    public static int reverse (int number){// Method to reverse original number
        int reverse = 0;
        while(number!=0){
            int lastDigit = number % 10;
            reverse *= 10;
            reverse += lastDigit;
            number /= 10;
        }
        return reverse;
    }

    public static int getDigitCount(int number){// Method to get the digit count of original/reversed number
        if(number<0){
            return -1;
        }
        int count = 0;
        // if the input is zero then return count = 1;
        if(number == 0){
            return count = 1;
        }
        while(number != 0){
            count++;
            int lastDigit = number % 10;
            number /= 10;
        }
        return count;
    }
}
