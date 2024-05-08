package keywordsExpressionsExpressionsStatements;

public class SecondsAndMinutesChallenge {
    public static void main(String[] args) {
        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(3945L));
    }
    /*Create method called getDurationString
        -should validate that the first parameter minutes is >=0
        -should validate that the second parameter seconds is >= and <=59
        -method should return "Invalid Value" in the method is either of the above are not true
        -if parameters are valid
            -Calculate how many hours, minutes, and seconds equal the minutes and seconds passed to
             this method
            -should return the value as string in format "XXh YYm ZZs"
                --XX represents hours, YY represents minutes, ZZ represents seconds
     */
    public static String getDurationString (long minutes, long seconds){
    if ((minutes < 0) || ((seconds < 0) || seconds > 59)){
        return "Invalid Value";
    }
    long hours = minutes/60;
    long remainingMinutes = minutes % 60;

    String hoursString = hours + "h";
    if (hours < 10 ) {
        hoursString = "0" + hoursString;
    }
    String remainingMinutesString = remainingMinutes + "m";
    if (remainingMinutes < 10 ) {
        remainingMinutesString = "0" + remainingMinutesString;
    }
    String secondsString = seconds + "s";
    if (seconds < 10 ) {
        secondsString = "0" + secondsString;
    }
        return hoursString +  remainingMinutesString + secondsString;
    }
    /*Create second method using same name
        -using only 1 parameter: seconds
     -Validate that it is >=0
        -return "Invalid Value" if it is not true
        -if valid
            -Calculate how many minutes are in the seconds value
            -then call the other overloaded method passing the correct minutes and seconds
             calculates so that it can calculate correctly.
     */
    public static String getDurationString (long seconds){
        if(seconds<=0) {
            System.out.println("Invalid value");
        }
        long remainingSeconds = seconds % 60;
        long minutes = seconds / 60;
        return getDurationString(minutes,remainingSeconds);
    }
}


