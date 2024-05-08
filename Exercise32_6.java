package com.example.hellofx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Exercise32_6 extends Application {
    private Statement statement;
    private final String[]  tableTitles = {"COLLEGE", "COURSE","DEPARTMENT", "ENROLLMENT",
    "FACULTY", "PERSON", "STATE", "STUDENT"};//Titles in table
    private final TextArea taResult = new TextArea();
    private final Button sTableButton = new Button("Show Contents");//Shows table
    private final Button clear = new Button("Clear All");
    private final ComboBox<String> combo = new ComboBox<>();//For the table titles
    final int taResultHeight = 375;
    final int taResultWidth = 775;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Creates main borderpane
        BorderPane main = new BorderPane();
        main.setCenter(new ScrollPane(taResult));

        //Sets text area dimensions for results
        taResult.setPrefHeight(taResultHeight);
        taResult.setPrefWidth(taResultWidth);

        //Adds button to clear info from the text area
        main.setBottom(clear);

        //Creates a border pane to hold the combobox
        BorderPane paneCB = new BorderPane();
        paneCB.setLeft(new Label("Select Table"));
        paneCB.setCenter(combo);
        paneCB.setRight(sTableButton);

        //Adds combo box to the top of main
        main.setTop(paneCB);

        //Set width for combo box
        combo.setPrefWidth(400);

        //Sets combo box start value
        combo.setValue("College");

        //Adds an array of names to observable list
        ObservableList<String>tables = FXCollections.observableArrayList(tableTitles);

        //Adds observable list to combo box
        combo.getItems().addAll(tables);

        // Create a scene and place it in the stage
        Scene scene = new Scene(main, 360, 130);//Creates scene
        primaryStage.setTitle("Exericse32.6: Database"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        //Calls method to initialize database connection and create
        //a query object
        initializeDB();

        //Sets actions for each button
        sTableButton.setOnAction(e -> showContents());
        clear.setOnAction(e -> taResult.clear());
    }//End of primary method
     //Initializes database connection
    public void initializeDB(){
        try {
            // Load the JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver loaded");

            // Establish a connection
            Connection connection =  DriverManager.getConnection("jdbc:ucanaccess://C:/Data/exampleMDB.accdb");
            System.out.println("Database connected");

            // Create a statement
            java.sql.Statement stmt = connection.createStatement();
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
    //showContents runs a query and displays the result in text area
    public void showContents() {
        String tableName;
        int numOfColumns;
        taResult.clear();
        tableName = combo.getValue(); //Get name of table from combobox
        try {
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Data/exampleMDB.accdb");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from " + tableName); //Execute SELECT query to get data from the table

            numOfColumns = resultSet.getMetaData().getColumnCount(); //Get number of columns in table

            //Prints the names of the columns as the first row
            int i;
            for (i = 1; i < numOfColumns + 1; i++) {
                taResult.appendText(resultSet.getMetaData().getColumnName(i) + "\t\t\t");
            }
            taResult.appendText("\n");

            //Prints the data from each row
            while (resultSet.next()) { //For each row in the table...

                for (i = 1; i < numOfColumns + 1; i++) { //For each column in the row...
                    taResult.appendText(resultSet.getString(i) + "\t\t\t"); //Get the data from each column and append it to the textArea
                }
                taResult.appendText("\n");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
