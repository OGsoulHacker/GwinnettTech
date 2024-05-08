public class J1_Lab05_1{
   //The months it takes until your principal of $100,000 becomes the half the amount ($50,000) if you send
   //5% of what you have every month.
    public static void main(String[] args) {
        double principal = 100000;   // months 0
        int months = 0;
        //Collect principal until reaching 150k(100k+50k from individual)
        while (principal < 150000) {
            //adding interest to principal
            principal = principal * 1.05;
            //Incremating months to count total months.
            months++;
            //Outputting data to display each total in each month.
            System.out.printf("You will have %.2f " + months + " months ", principal);
            System.out.print(System.lineSeparator());
        }
    }
}