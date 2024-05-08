package keywordsExpressionsExpressionsStatements;

public class ifKeywordAndCodeBlocks {
    public static void main (String[] args){
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

    //    if ((score < 5000) &&  (score > 1000) ) {
      //      System.out.println("Your score was less than 5000 but greater than 1000");
      //  } else if (score < 1000) {
      //      System.out.println("Your score was less than 1000");
      //  } else {
        //    System.out.println("Got here");
       // }
        if (gameOver){
            int finalScore = score + (levelCompleted * bonus);
            finalScore+=1000;
            System.out.println("Your final score was " + finalScore);
        }
//--------------------------------------------------------------------------
        boolean newGameOver = true;
        //score set to 10000
        int newScore = 10000;
        //level completed set to 8
        int newLevelCompleted = 8;
        //bonus set to 200
        int newBonus = 200;

        if (newGameOver){
            int finalScore = newScore + (newLevelCompleted * newBonus);
            System.out.println("Your final score was " + finalScore);
        }
//-----------------------------------------------------------------------------
        int newScore1 = 800;
        if (newScore1 >= 5000) {//expression result false
            System.out.println("Your score was >= to 5000");
            } else if ((newScore1 < 100) && ( newScore1 >= 500)) {//expression result true
            System.out.println("YOur score was < 1000 but >= 500");
                } else {
                System.out.println("Your score was 500");
                }
    }
}
