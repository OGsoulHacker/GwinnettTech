package keywordsExpressionsExpressionsStatements;
//needs to calculate the megabytes and remaining kilobytes from the kiloBytes parameter
// format should be "XX KB = YY MB and ZZ KB"
//EX: kiloBytes is 2500 needs to print "2500 KB = 2 MB"
//if the parameter kiloBytes is less than 0 then print "Invalid Value"
public class MegaBytes {
    public static void printMegaBytesAndKiloBytes (int kiloBytes){
        if (kiloBytes <0) {
            System.out.println("Invalid Value");
        } else {
            int megabytes = kiloBytes / 1024;
            int remainingKiloBytes = kiloBytes % 1024;
            System.out.println(kiloBytes + " KB = " + megabytes + " MB and " + remainingKiloBytes + " KB");
        }
    }
}
