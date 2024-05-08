package ControlFlowStatements;

public class WhileAndDoWhileLoop {
    public static void main(String[] args) {
        int count = 1;
        while (count != 6){
            System.out.println("Count value is" + count);
            count++;
        }
//For loop below NOT identical to the above loop
//        for (int i = 1; i<7; i++){
//            System.out.println("Count value it" + count);
        for (count = 1; count!=6; count++){
            System.out.println("Count value is" + count);
        }
        count = 1;
        while (true) {//infinite loop
            if (count == 6){//way to get out of the loop by checking if count equals to 6
                break;
            }
            System.out.println("Count value is" + count);
            count++;//count must be incremented
        }
        count =1;
        do {
            System.out.println("Count value is" + count);
            count++;
            if (count >100) {
            }
        } while ( count != 6);

        }
    }
