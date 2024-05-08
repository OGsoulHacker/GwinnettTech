package keywordsExpressionsExpressionsStatements;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        double num3 = num1 - num2;
        if (Math.abs(num3) <= 0.0009) {
            return true;
        } else {
            return false;
        }
    }
 //           int num1Int = (int)(num1 * 1000);

  //          int num2Int = (int)(num2 * 1000);


   //         if (num1Int == num2Int){

   //             return true;

  //          }else{

   //             return false;

            }

  //      }

  //  }
//}
//}
