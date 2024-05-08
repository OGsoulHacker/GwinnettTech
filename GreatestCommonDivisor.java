package ControlFlowStatements;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        int gcd = getGreatestCommonDivisor(50, 96);
        System.out.println("GCD " + gcd);

    }

    public static int getGreatestCommonDivisor(int first, int second){
        int gcd=0; // greatest common divisor.
        if(first<10 || second <10){ // if any of the 2 parameters are less than 10 return -1.
            return -1;
        } else {
            // we cannot divide by 0 so we start from 1.
            // in order to find the greatest common divisor, we must iterate through both first and second parameters.
            // this occurs until the condition is terminated.
            for(int i=1; i<=first && i<=second; i++){
                // both first and second have to be divisible by the same number.
                if(first%i==0 && second%i==0){
                    gcd=i;
                }
            }
            return gcd;
        }
    }

}
