package ControlFlowStatements;

public class SwitchStatement {
    public static void main(String[] args) {
        int value = 1;
        if (value == 1){
            System.out.println("Value was 1");
        } else if (value == 2) {
            System.out.println("Value was 2");
        } else {
            System.out.println("Value was not 1 or 2");
        }
//Switch statement equivalent to the above code.
        int switchValue = 1;//value to be tested
        switch(switchValue) {
            case 1: //Testing for literal value of 1
                System.out.println("Value was 1");
                break;//breaks out of switch statement
            case 2: //Testing for literal value of 2
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Value was a 3, 4, or 5");
                System.out.println("Actually it was a " + switchValue);
                break;
            default: //equivalent to else statement. Tests other circumstances
                System.out.println("Value was not 1, 2, 3, 4, or 5");
                break;
        }
        //more code here after break runs
    }
}
