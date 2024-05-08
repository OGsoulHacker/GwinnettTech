import java.util.Scanner;
public class j1_Lab04_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("======================================================================");
        System.out.println("Methods in Character class (7)");
        System.out.println("======================================================================");
        System.out.println("Method: is Digit");
        System.out.println("Is c a digit? " + Character.isDigit('c'));
        System.out.println("Is 5 a digit? " + Character.isDigit('5'));
        System.out.println("Method: is Letter");
        System.out.println("Is c a letter? " + Character.isLetter('c'));
        System.out.println("Is 5 a letter? " + Character.isLetter('5'));
        System.out.println("Method: is LowerCase");
        System.out.println("Is c lowercase?" + Character.isLowerCase('c'));
        System.out.println("Method: isUpperCase");
        boolean s3upper = Character.isUpperCase('s');
        System.out.println("Is s in uppercase? " + s3upper);
        System.out.println("Method: to Lowercase");
        char s1lower = Character.toLowerCase('s');
        System.out.println("What is S in lowercase? " + s1lower);
        System.out.println("Method: to UpperCase");
        char s2upper = Character.toUpperCase('s');
        System.out.println("What is s in uppercase? " + s2upper);
        System.out.println("======================================================================");
        System.out.println("Methods for comparing Strings (7)");
        System.out.println("======================================================================");
        System.out.println("Method: equals");
        String s1 = "Welcome";
        String s2 = "welcome";
        if (s1.equals(s2)) {
        } else {
            System.out.println("Welcome and welcome are not the same");
        }
        System.out.println("Method: equalsIgnoreCase");
        String s3 = "Welcome";
        String s4 = "welcome back";
        if (s3.equalsIgnoreCase(s4)) {
        } else {
            System.out.println("Welcome and welcome are the same");
        }
        System.out.println ("Method: compareTo");
            String s5 = "Welcome";
            String s6 = "welcome back";
            System.out.println(s5.compareTo(s6));
            System.out.println("Welcome and welcome back are not the same");
        //System.out.println ("Method: log");

        System.out.println ("Method: compareToIgnoreCase");
            String s7 = "Welcome";
            String s8 = "welcome";
            System.out.println(s7.compareToIgnoreCase(s8));
        System.out.println("Welcome and welcome are the same");
            System.out.println ("Method: startsWith, ends with");
            String s9 = "Welcome";
            System.out.println(s9.startsWith("wel"));
            System.out.println(s9.endsWith("come"));
        System.out.println("======================================================================");
        System.out.println("Methods for String object (8)");
        System.out.println("======================================================================");
            System.out.println ("Method: length");
                String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                System.out.println(txt.length());
            System.out.println ("Method: charAt");
                String myStr = "Hello";
                char result = myStr.charAt(0);
                System.out.println(result);
            System.out.println ("Method: concat");
                String firstName = "John ";
                String lastName = "Doe";
                System.out.println(firstName.concat(lastName));
            System.out.println ("Method: trim");
                String myStr1 = "       Hello World!       ";
                System.out.println(myStr1);
                System.out.println(myStr1.trim());
        System.out.println ("Method: substring(n)");
                String n = new String("Rs 1000");

                // Printing original string
                System.out.print("The original string  is : ");
                System.out.println(n);

                // using substring() to extract substring
                // returns 1000
                System.out.print("The extracted substring  is : ");
                System.out.println(n.substring(3));
        System.out.println ("Method: substring (n1, n2)");
            String n1 = new String("Welcome");
            String n2 = new String ("back");
                System.out.print("The original string  is : ");
                System.out.println(n1);
                System.out.print("The extracted substring  is : ");
                System.out.println(n1.substring(3));
                System.out.print("The original string  is : ");
                System.out.println(n2);
                System.out.print("The extracted substring  is : ");
                System.out.println(n2.substring(3));
        System.out.println("======================================================================");
        System.out.println("Finding in a String (8)");
        System.out.println("======================================================================");
            System.out.println ("Method: indexOf (ch)");
                String n3 = new String("Welcome to java");
                System.out.print("Found j  at position : ");
                // index of 'g' will print
                System.out.println(n3.indexOf('j', 7));
            System.out.println ("Method: indexOf (ch, i)");
                String myStr2 = "Hello planet earth, ";
                String myStr3 = "you are a great planet.";
                System.out.print("Found p  at position : ");
                System.out.println(myStr2.indexOf('p', 7));
                System.out.print("Found p  at position : ");
                System.out.println(myStr3.indexOf('p', 7));
            System.out.println ("Method: indexOf(s)");
                String Str4 = new String("Welcome to java");

                // Initialising search string
                String subst = new String("java");

                // print the index of initial character
                // of Substring
                // prints 11
                System.out.print("Found java starting at position : ");
                System.out.print(Str4.indexOf(subst));

            System.out.println ("Method: indexOf (s, i)");

            System.out.println ("Method: lastIndexOf (ch)");
                String Str5 = new String("Welcome to Java");
                System.out.print("Found Index :" );
                System.out.println(Str5.indexOf( 'o', 5 ));
            System.out.println ("Method: lastIndexOf (s)");
                String myStr6 = "Hello planet earth, you are a great planet.";
                System.out.println(myStr6.lastIndexOf("e", 5));
            System.out.println ("Method: lastIndexOf (s, i)");
                String Str7 = new String("Welcome to Java");
                String SubStr1 = new String("Welcome" );
                System.out.print("Found Index :" );
                System.out.println( Str7.indexOf( SubStr1, 8 ));
        System.out.println("======================================================================");
        System.out.println("Conversion b/w String & Number(2");
        System.out.println("======================================================================");
        System.out.println ("parsInt ()");
        System.out.println ("parseDouble()");
        System.out.println("======================================================================");
        System.out.println("Study of printf");
        System.out.println("======================================================================");
        System.out.println("printf %-10d%-10.4f%-10.4f%-10.4f%-10.4f , a,b,c,d,e");
        int a = 1;
        double b = 2;
        double c = 3;
        double d = 4;
        double e = 5;
        System.out.printf( "%-10d % -10.4f % -10.4f % -10.4f % -10.4f", a, b, c, d, e);
    }
  }

