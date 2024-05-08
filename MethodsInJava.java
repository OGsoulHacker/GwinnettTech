package keywordsExpressionsExpressionsStatements;

public class MethodsInJava {
    public static void main(String[] args) {
/*Create a method called displayHighScorePosition (void method)
   -it should display a players name as a parameter, a 2nd parameter as a position in the high score table
   -you should display the players name along with a message like "managed to get into position"
    and the position they got, and a further message "on the high score table"

  *Create a second method called caclulateHighScorePosition
   -should be sent one argument only, the player score
   -should return an int
   -return data should be:
    -return 1: if the score is >1000
    -return 2: if the score is >500 and <1000
    -return 3: if the score is >100 and < 500
    -return 4: in all other cases
   -Call both methods and display the results of the following:
    -score of 1500,900,400, and 50

  */
        //Assigns var to method  //Calls method calculateScore()     //arguments to be sent to method
        int highScore = calculateScore(true, 800, 5, 100);
        System.out.println("Your final score was " + highScore);
        calculateScore(true, 10000, 8, 200);

        int highScorePosition = calculateHighScorePosition(1500);
        displayHighScorePosition("Misa", highScorePosition);

        highScorePosition = calculateHighScorePosition(900);
        displayHighScorePosition("Ron", highScorePosition);

        highScorePosition = calculateHighScorePosition(400);
        displayHighScorePosition("Justyn", highScorePosition);

        highScorePosition = calculateHighScorePosition(50);
        displayHighScorePosition("Alex", highScorePosition);

        highScorePosition = calculateHighScorePosition(1000);
        displayHighScorePosition("Izzy", highScorePosition);

        highScorePosition = calculateHighScorePosition(500);
        displayHighScorePosition("Sten", highScorePosition);

        highScorePosition = calculateHighScorePosition(100);
        displayHighScorePosition("Junho", highScorePosition);
    }

    //method passed 4 parameters from main method to calculateScore method
    public static void displayHighScorePosition(String playersName, int highScorePosition) {
        System.out.println(playersName + " managed to get into position "
                + highScorePosition + " on the high score table");
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score + (levelCompleted * bonus);
        finalScore += 2000;
        return finalScore;
    }

    public static int calculateHighScorePosition(int playerScore) {
 //       if (playerScore >= 1000) {
 //           return 1;
 //       } else if (playerScore >= 500) {
 //           return 2;
 //           } else if (playerScore >= 100) {
  //          return 3;
  //      }
  //      return 4;

        int position = 4; //Assuming position 4 will be returned
        if (playerScore >= 1000) {
            position = 1;
            } else if (playerScore >= 500) {
                position = 2;
            } else if (playerScore >= 100) {
                position = 3;
            }
        return position; //default position
    }
}