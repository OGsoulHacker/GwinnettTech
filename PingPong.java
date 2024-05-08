package ch32;
import java.lang.Runnable;
import java.lang.Thread;
//====================================================================================
/*
> Write a PingPong class that implements the Runnable interface
  and will write ping or pong in a console window.
  Have it print the word (ping or pong) at least 10 times before it terminates
> Write a program that creates and runs two threads using the PingPong class.
    * One that prints ping.
    * One that prints pong.
> Additional Notes:
    * The PingPong class should print ping or pong only.
    * It should not even be able to print anything else.
    * You can use the constructor to set up which it prints:
        > (ping or pong).
    * Use a loop in the PingPong class to print at least 10 times
        > and have the thread sleep for at least 10 seconds each time through the loop.
    * The main program should create and run two instances of the PingPong class.
        > one that does ping and one that does pong.
*/
//=====================================================================================
public class PingPong {
        public static void main(String[] args) {
            //Creates task for printPing and pringPong
            Runnable printPing = new PrintPingPong(true,10);
            Runnable printPong = new PrintPingPong(false, 10);

            //Creates threads: one prints ping, one prints pong
            Thread thread1 = new Thread(printPing);
            Thread thread2 = new Thread(printPong);

            //Starts threads
            thread1.start();
            thread2.start();
        }
    }
//Task for printing ping and pong 10x
//Class for PrintPingPong that implements runnable
    class PrintPingPong implements Runnable {
        private String stringToPrint; // The character to print
        private int times; // The times to repeat
//Constructs a task with specified word printing the specified number of times
        public PrintPingPong(boolean printPing, int t) {
            times = t;
            if (printPing == true){
                stringToPrint = "Ping";
            }else{
                stringToPrint = "Pong";
            }
        }

    @Override
        //Overrides the run() method, telling the system which task to perform
        public void run() {
            for (int i = 0; i < times; i++) {//Creates and launches 10x
                System.out.print(stringToPrint);
                try {
                    Thread.sleep(10000);
                }
                catch (InterruptedException ex) {
                }
            }
        }
    }
