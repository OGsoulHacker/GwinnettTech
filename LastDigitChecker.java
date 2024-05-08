package ControlFlowStatements;

public class LastDigitChecker {
    public static void main(String[] args) {
        boolean same = hasSameLastDigit(9,99,19);
        System.out.println(same);
    }

    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
    //each parameter within range of 10 -1000, if one number is not within range method should return false.
        if (isValid(num1) && isValid(num2) && isValid(num3) ){
            int rightNum1 = num1 % 10;
            int rightNum2 = num2 % 10;
            int rightNum3 = num3 % 10;

            if(rightNum1 == rightNum2 || rightNum2 == rightNum3 || rightNum3 == rightNum1){
                return true;
            }else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public static boolean isValid(int num4) {
        if (num4 >= 10 && num4 <= 1000) {//checks if number parameter is in range of 10 - 1000.
            return true;
        }
        return false;
    }
}
