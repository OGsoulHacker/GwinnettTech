public class J1_Lab05_3 {
        //main method
        public static void main(String[] args) {
            // Display the table heading
            System.out.println("           Pair table");

            // row title
            System.out.print("       ");
            for (int j = 1; j <= 5; j++)
                System.out.print("   " + j);

            System.out.println("\n-----------------------------------------");

            // Print for table body
            //1st For changing I
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " | ");
            //2nd For loop changing variable J.
                for (int j = 1; j <=5; j++) {
                    // Displaying columns and rows
                    System.out.printf("(" + i + "," +j + ") ");
                }
                System.out.println();
            }
        }
    }

