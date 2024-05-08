public class MainPrimitiveTypes {
    public static void main(String[] args) {

        int myValue = 10000;
        //Determines minimum value range
        int myMinIntValue = Integer.MIN_VALUE;
        //Determines minimum value range
        int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println("Integer Minimum Value = " + myMinIntValue);
        System.out.println("Integer Maximum Value = " + myMaxIntValue);
        System.out.println("Busted MAX value = " + (myMaxIntValue + 1));
        System.out.println("Busted MIN value = " + (myMinIntValue - 1));

        int myMaxIntTest = 2_147_483_647;
    }
}
