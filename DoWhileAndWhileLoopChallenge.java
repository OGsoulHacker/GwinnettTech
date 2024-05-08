package ControlFlowStatements;

public class DoWhileAndWhileLoopChallenge {
    //Create methos called isEvenNumber that takes a parameter of type int
//Its purpose is to determine if the argument passed to the methods is
//an even number or not
//return true if an even number, otherwise return false
    public static void main(String[] args) {
        int count = 0;
        int number = 4;
        int finishNumber = 20;
        int evenNumbersFound = 0;
        while (number <= finishNumber) {
            number++;//increments number as 1st statement
            if (!isEvenNumber(number)) {//tests if number is not even or is even
                continue;//bypasses print statement or code, goes back to start of loop
            }
            System.out.println("Even number" + number);

            evenNumbersFound++;
            if (evenNumbersFound >= 5){//breaks once 5 even numbers are found
                break;
            }
        }
        //Displays total number of even numbers found
        System.out.println("Even numbers found" + evenNumbersFound);
    }

    public static boolean isEvenNumber(int number) {
        if ((number % 2) == 0) {
            return true;
        } else {
            return false;
        }
    }
}

 //       do {
 //           System.out.println("Number is even " + number);
 //           if ((number % 2)  == 0) {
//
//            }
//        } while (number <= finishNumber)
//        return true;
 //   }
//    return false;



