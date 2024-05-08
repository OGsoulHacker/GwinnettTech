package ControlFlowStatements;

public class SwitchChallenge {
/*Create switch statement
*   >Create a new char variable
*   >Create a switch statement testing for:
*       - A, B, C, D, or E
*   >Display a message saying "found" if any of these are found, then break
*   >Add a default that displays the message "Not found"
*/
    public static void main(String[] args) {
        char switchChar = 'c';
        switch (switchChar) {
            case 'a': case 'b': case 'c': case 'd': case 'e':
                System.out.println("Char value found to be in range of A-E");
                break;
            default:
                System.out.println("Char value was not found to be in range of A-E");
                break;
        }
        String month = "May";
        switch (month){
            case "January":
                System.out.println("month is " + month);
                break;
            case "February":
                System.out.println("month is " + month);
                break;
            case "March":
                System.out.println("month is " + month);
                break;
            case "April":
                System.out.println("month is " + month);
                break;
            case "May":
                System.out.println("month is " + month);
                break;
            default:
                System.out.println("month is not" + month);
                break;
        }
    }
}
