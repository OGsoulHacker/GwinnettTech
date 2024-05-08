import java.sql.Array;
import java.util.Random;

public class practice {
    public static void main(String[] args ){
       int i = 0;
       int j = 0;

       Random rand = new Random();

       //create an array of random size and fill it with numbers 1 through (arraySize)
       int arraySize = rand.nextInt(11);
       int[] numbers = new int[arraySize];
       for(i = 0; i < numbers.length; i++){
           numbers[i] = i+1;
       }

       while(i<11){
           System.out.println(i);
           i++;
       }
       do {
           System.out.println("Just doing things" + j);
           j++;
       }
       while (j<11);
       for(int number : numbers){
           System.out.println("I'm number " + number + "!");
       }
    }
}

