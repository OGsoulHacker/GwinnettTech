// The following code is working fine. (Two fixes were applied)

// Compile the following program
package ch34;

import java.sql.*;

public class Exercise32_05
{

    private static void initializeDB()
    {
        try {
            // Load the JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver loaded");

            // Establish a connection
            Connection connection =  DriverManager.getConnection("jdbc:ucanaccess://C:/Data/exampleMDB.accdb");
            System.out.println("Database connected");

            // Create a statement
            Statement stmt = connection.createStatement();
            System.out.println("Statement connected");

            // Fill the list with the table names
            DatabaseMetaData dbMetaData = connection.getMetaData();
            System.out.println("MetaData created");
            ResultSet tableNames = dbMetaData.getTables(null, null, null, new String[] {"TABLE"});
            System.out.println("ResultSet created");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Test driver
    public static void main(String[] args) {
        // Call the setup connection function
        initializeDB();
    }
}
 
