package keywordsExpressionsExpressionsStatements;

public class KeywordsAndExpressions {
    public static void main (String[] args) {
        //Keywords are in orange and or blue
        //Expressions are building blocks, built with values, variables, and operators
        //miles to kilometers
        // mile is equal to 1.609344 kilometers
        double kilometers = (100 * 1.609344);
        System.out.println("Kilometers:" + kilometers);
        int highScore = 50;
        if (highScore == 50) {
            System.out.println("This is an expression");
        }
     // In the following code, what parts are expressions
        //score = 100
        int score = 100;
        // score>99
        if (score>99) {
            //"You got high score"
            System.out.println("You got high score");
            score = 0;
        }
    }
}

