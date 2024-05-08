public class J1_Lab05_2 {
    public static void main(String[] args) {
        //converting for to while
        //for (int j = 1; j <= 9; j++)
        // System.out.print(" " + j);
        int j = 1;
        while (j <= 9) {
            System.out.print("J is " + j);
            j++;
        }
        System.out.println("\n-----------------------------------------");
        //converting For loop to While
        // for (int i = 1; i <= 9; i++) {
        //System.out.print(i + " | ");
        // for (int j = 1; j <= 9; j++) {
        // System.out.printf("%4d", i * j);
        //int i = 1;
        int i = 1;
        while (i <= 9) {
            System.out.print(" | is " + i);
            i++;
            while (j <= 9) {
                System.out.printf("%4d", i * j);
                j++;
            }
            System.out.println();

            }
        }
    }